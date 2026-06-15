package framework.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.driverfactory.DriverManager;

public class BasePage {

	protected WebDriver driver;
	private WebDriverWait wait;
	private Actions actions;
	
	public BasePage() {
		driver = DriverManager.getDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		actions = new Actions(driver);
	}
	
	protected void acessarSite(String url) {
		driver.get(url);
	}
	
	protected void clicar(By by) {
		WebElement element = waitElementIsClickable(by);
		
		try {
			element.click();
		}catch(Exception ex) {
			actions.click(element).build().perform();
		}
	}
	
	protected void clicar(WebElement elem) {
		WebElement element = waitElementIsClickable(elem);
		
		try {
			element.click();
		}catch(Exception ex) {
			actions.click(element).build().perform();
		}
	}
	
	protected boolean elementoExiste(By by) {
		return esperarElementoVisivel(by) != null;
	}
	
	protected void digitar(By by, String text) {
		WebElement element = esperarElementoVisivel(by);
		
		try {
			element.click();
			element.clear();
			element.sendKeys(text);
		}catch(Exception ex) {
			actions.click(element).build().perform();
			element.clear();
			actions.sendKeys(element, text).build().perform();
		}
	}
	
	protected void digitar(WebElement elem, String texto) {
		
		WebElement element = esperarElementoVisivel(elem);
		
		try {
			element.click();
			element.clear();
			element.sendKeys(texto);
		}catch(Exception ex) {
			actions.click(element).build().perform();
			element.clear();
			actions.sendKeys(element, texto).build().perform();
		}
	}
	
	protected WebElement esperarElementoVisivel(WebElement elem) {
		return wait.until(ExpectedConditions.visibilityOf(elem));
	}
	
	protected WebElement esperarElementoVisivel(By by) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	protected List<WebElement> esperarListaDeElementosVisiveis(By by) {
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
	}
	
	protected List<String> getListaDeTextosAPartirDeWebElement(List<WebElement> listaElementos) {
		
		List<String> tempList = new ArrayList<String>();
		
		for(WebElement elem : listaElementos) {
			tempList.add(elem.getText());
		}
		
		return tempList;
	}
	
	
	protected void selecionarItemComboPorTexto(By by, String texto) {
		
		Select select = new Select(esperarElementoVisivel(by));
		
		select.selectByVisibleText(texto);
		
	}
	
	/*private int getTamanhoTela(String posicao) {
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	//Largura
	if (posicao == "x") {
		return ((Long) js.executeScript("return window.innerWidth;")).intValue();
	//Altura
	}else {
		return ((Long) js.executeScript("return window.innerHeight;")).intValue();
	}
}

private double retornarTamanhoRelativo(int posicaoElemento, int tamanhoTela) {
	return (double) posicaoElemento / tamanhoTela;
}

protected boolean isAlinhadoHorizonalmente(WebElement elemento, double esperadoX, double tolerancia) {
	int tamanhoHorizontal = getTamanhoTela("x");
	int x = elemento.getLocation().getX();
	double relativeX = retornarTamanhoRelativo(x,tamanhoHorizontal);
	
	return relativeX >= (esperadoX - tolerancia) &&
			relativeX <= (esperadoX + tolerancia);
}

protected boolean isAlinhadoVerticalmente(WebElement elemento, double esperadoY, double tolerancia) {
	int tamanhoVertical = getTamanhoTela("y");
	int x = elemento.getLocation().getX();
	double relativeY = retornarTamanhoRelativo(x,tamanhoVertical);
	
	return relativeY >= (esperadoY - tolerancia) &&
			relativeY <= (esperadoY + tolerancia);
}


public boolean isAlinhadoHorizontalmente(WebDriver driver, WebElement elemento,
        double expectedX, double tolerance) {

	JavascriptExecutor js = (JavascriptExecutor) driver;
	int windowWidth = ((Long) js.executeScript("return window.innerWidth;")).intValue();
	
	int x = elemento.getLocation().getX();
	double relativeX = (double) x / windowWidth;
	
	return relativeX >= (expectedX - tolerance) &&
	relativeX <= (expectedX + tolerance);
}*/

	
	protected boolean waitTitleText(String expectedTitleText) {
		return wait.until(ExpectedConditions.titleContains(expectedTitleText));
	}
	
	protected WebElement waitElementIsClickable(By by) {
		return wait.until(ExpectedConditions.elementToBeClickable(by));
	}
	
	protected WebElement waitElementIsClickable(WebElement element) {
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	protected void doubleClick(WebElement element) {
		actions.doubleClick(waitElementIsClickable(element))
		.build().perform();
		
	}
	
	protected void doubleClick(By by) {
		WebElement element = waitElementIsClickable(by);
		actions.doubleClick(element).build().perform();
	}
	
	
	
	protected void dragAndDrop(WebElement elementSource, WebElement elementTarget) {
		actions.dragAndDrop(elementSource, elementTarget).build().perform();
	}
	
	protected void moveToElementPoint(int xPosition, int yPosition) {
		actions.moveToLocation(xPosition, yPosition).build().perform();
	}
	
	protected void moveToElement(WebElement element) {
		actions.moveToElement(element).build().perform();
	}
	
}
