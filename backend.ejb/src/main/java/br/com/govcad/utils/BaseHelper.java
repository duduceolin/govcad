package br.com.govcad.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseHelper {

	protected static WebDriver driver;

	/**
	 * Método obrigatório para implementação. Entrada é o objeto de consulta do
	 * usuário.
	 * 
	 * @param entrada
	 */
	public abstract void iniciarProcessamento(Object entrada);

	/**
	 * Método para carregar no driver um endereço passado como parâmetro
	 * 
	 * @param endereco
	 * @throws IOException
	 */
	public void carregarEndereco(String endereco) throws IOException {
		driver = iniciarDriverFirefox(endereco);
	}

	/**
	 * Iniciar o firefox com a URL passada por parâmetro.
	 * 
	 * @param appURL
	 * @return
	 * @throws IOException
	 */
	private static WebDriver iniciarDriverFirefox(String appURL) throws IOException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}

	/**
	 * Método para buscar uma imagem pelo By e salvar em um local loc.
	 * 
	 * @param by
	 * @param loc
	 * @throws IOException
	 */
	public static void baixarImagemPeloBy(By by, String loc) throws IOException {
		WebElement Image = driver.findElement(by);

		File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		int width = Image.getSize().getWidth();
		int height = Image.getSize().getHeight();
		BufferedImage img = ImageIO.read(screen);
		BufferedImage dest = img.getSubimage(Image.getLocation().getX(), Image.getLocation().getY() + 100, width,
				height);
		ImageIO.write(dest, "png", screen);
		File file = new File(loc);
		FileUtils.copyFile(screen, file);
	}

	/**
	 * Método para buscar um elemento pelo seu ID.
	 * 
	 * @param idElemento
	 * @return
	 */
	public WebElement buscarElementoPeloId(String idElemento) {
		WebDriverWait espera = new WebDriverWait(driver, 10);
		WebElement elemento = espera.until(ExpectedConditions.visibilityOfElementLocated(By.id("idElemento")));
		return elemento;
	}

	/**
	 * Método para mudar o frame de uma página.
	 * 
	 * @param nomeFrame
	 */
	public void mudarFrame(String nomeFrame) {
		driver.switchTo().frame(nomeFrame);
	}

	/**
	 * Método para alterar valor de um webelement.
	 * 
	 * @param elemento
	 * @param valor
	 */
	public void alterarValorCampo(WebElement elemento, String valor) {
		elemento.sendKeys(valor);
	}

}
