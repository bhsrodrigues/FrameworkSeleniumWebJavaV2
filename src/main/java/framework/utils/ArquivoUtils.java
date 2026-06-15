package framework.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * Classe para manipulação de dados em TXT caso seja necessário compartilhar
 * valores entre cenários de testes diferentes
 */
public class ArquivoUtils {

	private static final Lock lock = new ReentrantLock();
	private static final String baseNomePadraoDiretorio = "ExecucaoAutomacao";
	private static final String baseNomePadraoArquivo = "arquivoTemporario";
	private static final String PADRAO_FULL_PARAMETRO_SALVO = "Key %s | Value %s";
	private static final String PADRAO_FULL_PARAMETRO_CHAVE = "Key %s | Value ";
	private static final ThreadLocal<String> nomeCaminho = ThreadLocal.withInitial(() -> {
		long threadId = Thread.currentThread().threadId();
		return baseNomePadraoDiretorio + threadId;
	});
	
	private ArquivoUtils() {};
	
	//Salvará um parâmetro para ser usado em outro(s) cenário(s)
	public static void salvarParametroArquivo(String cenario, Map<String, String> dados) throws IOException{
		lock.lock();
		try {
			
			//Método erifica se caminho existe, senão cria
			criarDiretorio(nomeCaminho.get());
			
			String arquivo = baseNomePadraoArquivo + cenario + ".txt";
			String fullpath = nomeCaminho.get()  + File.separator + arquivo;
			
			System.out.println(File.separator + "\n" + File.separatorChar + 
					"\n" + File.pathSeparator + "\n" + File.pathSeparatorChar);
			
			criarArquivo(fullpath);
			
			File fileTemp = new File(fullpath);
			
			//Começa a salvar o arquivo
			try (PrintWriter writer = new PrintWriter(new FileWriter(fileTemp, true))){
				preencherArquivo(dados, writer);
			}
		}finally {
			lock.unlock();
		}
		
	}
	
	
	private static void criarArquivo(String fullpath) throws IOException {
		File file = new File(fullpath);
		try {
			
			if (!file.exists()) {
				Files.createFile(Paths.get(fullpath));
			}
			
		}catch (Exception ex) {
			System.err.println(ex.getLocalizedMessage());
		}
	}

	public static void substituirInformacao(String key, String cenario, String newKey, String newValue) {
		
		lock.lock();
		//String path = nomeCaminho.get() + File.separator + baseNomePadraoArquivo + cenario + ".txt";
		//List<String> linhasArquivo;
		//String linha;
		//List<String> novasLinhasArquivo = null;
		Map<String, String> novasChaves = new HashMap<>();
		
		try {
			/*linhasArquivo = pegarLinhasArquivo(path);
			linha = retornarLinhaCompleta(linhasArquivo, key);*/
			String valor = pegarInformacaoArquivo(key, cenario, true);
			novasChaves.put(key, newValue);
			novasChaves.put(newKey, valor);
			
			salvarParametroArquivo(cenario, novasChaves);
			
			
		}catch(IOException ioex) {
			System.out.println(ioex.getMessage());
		}finally {
			lock.unlock();
		}
		
		 
		//String valor = pegarInformacaoArquivo(key, cenario, false);
		
		
		
	}
	
	private static String retornarLinhaCompleta(List<String> linhasArquivo, String key) throws IOException{
		String linha = "";
		
		for (String x : linhasArquivo) {
			if (x.contains(key)) {
				linha = x;
				//value = x.replace(String.format(PADRAO_FULL_PARAMETRO_CHAVE, key), "").trim();
				break;
			}
		}
		
		return linha;
	}
	
	private static List<String> pegarLinhasArquivo(String path) throws IOException{
		return Files.readAllLines(Paths.get(path));
	}
	
	public static String pegarInformacaoArquivo(String key, String cenario, boolean apagar){
		
		lock.lock();
		String path = nomeCaminho.get() + File.separator + baseNomePadraoArquivo + cenario + ".txt";
		List<String> linhasArquivo = null;
		String linha = "";
		String value = "";
		
		try {
			linhasArquivo = pegarLinhasArquivo(path);
			
			linha = retornarLinhaCompleta(linhasArquivo, key);
			value = linha.replace(String.format(PADRAO_FULL_PARAMETRO_CHAVE, key), "").trim();
			
			
			
			if (apagar) {
				List<String> novasLinhasArquivo = deletarLinhaArquivo(linhasArquivo, linha);
				Files.write(Paths.get(path), novasLinhasArquivo);
			}
			
		}catch (IOException ex) {
			System.err.println(ex.getMessage());
		}
		lock.unlock();
		return value;
	}
	
	private static List<String> deletarLinhaArquivo(List<String> linhasArquivo, String linha) {
		List<String> linhasParaGravar = new ArrayList<>();
		
		for (String x : linhasArquivo) {
			if (!x.equals(linha)) {
				linhasParaGravar.add(x);
			}
		}
		
		return linhasParaGravar;
	}
	
	private static void preencherArquivo(Map<String, String> dados, PrintWriter writer) {
		
		for (Map.Entry<String, String> item: dados.entrySet()) {
			informarLinha(item.getKey(),item.getValue(),writer);
		}
		
	}
	
	private static void informarLinha(String key, String value, PrintWriter writer) {
		//writer.println(String.format(PADRAO_FULL_PARAMETRO_SALVO,key,value ));
		System.out.println(String.format("Key %s | Value %s ", key,value));
		writer.println(String.format(PADRAO_FULL_PARAMETRO_SALVO,key,value ));
	}

	private static void criarDiretorio(String caminho) {
		File dir = new File(caminho);
		
		if (!dir.exists()) {
			dir.mkdirs();
		}
	}
	
	// Método para limpar arquivos temporários antigos
    public static void limparArquivosTemporarios() {
        File dir = new File(nomeCaminho.get());
        // Lista todos os arquivos/diretórios dentro do diretório base
        File[] arquivos = dir.listFiles();

        if (arquivos != null) {
            for (File arquivo : arquivos) {
                // Verifica se o nome do arquivo/diretório começa com 'tempprojetoxpto'
                //if (arquivo.isDirectory() && arquivo.getName().startsWith(baseNomePadraoArquivo)) {
                if (arquivo.getName().startsWith(baseNomePadraoArquivo)) {
            		// Remove o diretório e seus conteúdos
                	arquivo.delete();
                }
            }
        }
        
        arquivos = dir.listFiles();
        
        if(arquivos == null || arquivos.equals(null) || arquivos.length == 0) {
        	dir.delete();
        }
    }
	
}
