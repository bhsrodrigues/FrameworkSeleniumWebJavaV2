package framework.pages;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomeSauceDemoPage extends BasePage{
	
	private By cmbFiltroProdutos = By.cssSelector(".select_container > .product_sort_container");
	private By lblNomeProdutos = By.cssSelector(".inventory_item_label .inventory_item_name");
	private By lblValorProdutos = By.cssSelector(".inventory_item .pricebar > .inventory_item_price");
	private List<WebElement> listElements;
	private List<String> listaNomesProdutos;
	private List<BigDecimal> listaValores;
	
	
	public HomeSauceDemoPage() {
		super();
		
	}
	
	public boolean getComboFiltroExiste() {
		return elementoExiste(cmbFiltroProdutos);
	}
	
	public void selecionarFiltro(String filtro) {
		
		selecionarItemComboPorTexto(cmbFiltroProdutos,filtro);
		
		if (filtro.equals("Name (Z to A)") || filtro.equals("Name (A to Z)")) {
			listaNomesProdutos = getListaDeTextosAPartirDeWebElement(
					esperarListaDeElementosVisiveis(lblNomeProdutos));
		}else {
			List<String> valoresTemp = getListaDeTextosAPartirDeWebElement(
					esperarListaDeElementosVisiveis(lblValorProdutos));
			
			valoresTemp = valoresTemp.stream().map(item -> item.replace("$", "")).toList();
			
			listaValores = valoresTemp.stream().map(BigDecimal::new).toList();
		}
		
	}
	
	public boolean validarOrdenacaoNome(boolean ascendente) {
		
		if (ascendente) 
			Collections.sort(listaNomesProdutos);
		else 
			Collections.sort(listaNomesProdutos, Collections.reverseOrder());
		
		int posicao = 0;
		
		
		listElements = esperarListaDeElementosVisiveis(lblNomeProdutos);
		
		for(WebElement elem : listElements) {
			
			if (!elem.getText().equals(listaNomesProdutos.get(posicao))) {
				return false;
			}
			posicao+= 1;
		}
		return true;
	}
	
	public boolean validarOrdenacaoValores(boolean ascendente) {
		if (ascendente)
			listaValores = listaValores.stream().sorted(Comparator.naturalOrder()).toList();
		else
			listaValores = listaValores.stream().sorted(Comparator.reverseOrder()).toList();
		
		int posicao = 0;
		
		listElements = esperarListaDeElementosVisiveis(lblValorProdutos);
		
		for(WebElement elem : listElements) {
			
			if (!(listaValores.get(posicao).compareTo(new BigDecimal(
					elem.getText().replace("$", ""))) == 0)) {
				return false;
			}
			posicao+= 1;
		
		}
		return true;
	}
}
