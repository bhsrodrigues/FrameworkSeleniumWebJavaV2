package framework.config;

import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

	
	private static ConfigManager configInstance;
	private Properties propriedadeAutomacao = new Properties();
	
	private ConfigManager() {
		carregarArquivoPropriedades();
	}
	
	public static synchronized ConfigManager getInstance() {
		if (configInstance == null) {
			configInstance = new ConfigManager();
		}
		
		return configInstance;
	}
	
	/**
	 * Método para carregar o arquivo de propriedades. Caso ocorra algum problema para
	 * carregar o arquivo de configuração, informa que será usado a configuração padrão.
	 */
	private void carregarArquivoPropriedades() {
		try(InputStream is = getClass().getClassLoader()
				.getResourceAsStream("config.properties")){
			if (is != null) {
				propriedadeAutomacao.load(is);
			}
		}catch (Exception ex) {
			System.err.println("Não foi encontrado arquivo de configuração \n+"
					+ "Será usada a configuração padrão");
		}
	}
	
	
	/**
	 * Retorna o valor de uma configuração específica do navegador.
	 * Caso o valor passado não exista ou não seja fornecido nenhum valor, será usada a configuração padrão
	 * @param key Chave da propriedade desejada
	 * @param valorDefault Valor padrão para o caso da propriedade não ser encontrada
	 * @return String com o valor da propriedade para a automação
	 */
	public String getConfiguracao(String key, String valorDefault) {
		String valorPropriedade = System.getProperty(key);
		
		if (valorPropriedade != null && !valorPropriedade.isBlank()) {
			return valorPropriedade.trim();
		}else {
			return propriedadeAutomacao.getProperty(key,valorDefault);
		}
		
	}
	
	public String getBrowser() {
		return getConfiguracao("browser", "chrome");
	}
	
	public boolean getHeadless() {
		return Boolean.parseBoolean(getConfiguracao("headless", "false"));
	}
	
	public int getEsperaCarregamentoPagina() {
		return Integer.parseInt(getConfiguracao("esperaCarregamentoPagina","30"));
	}
	
	public int getEsperaExplicitaElemento() {
		return Integer.parseInt(getConfiguracao("esperaExplicita","30"));
	}
}
