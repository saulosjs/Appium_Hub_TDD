package br.com.rsinet.hub_TDD.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.rsinet.hub_TDD.excel.Constant;
import br.com.rsinet.hub_TDD.excel.ExcelUtils;
import io.appium.java_client.android.AndroidDriver;

public class PageCadastro {
	private static String usuario;
	private static String atual;

	public PageCadastro() throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha1");
	}

	public void preencherUsuario(AndroidDriver<WebElement> driver, int linha) throws Exception {
		driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.EditText"))
				.sendKeys(ExcelUtils.getCellData(1, 0));
	}

	public void preencherEmail(AndroidDriver<WebElement> driver, int linha) throws Exception {
		driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.EditText"))
				.sendKeys(ExcelUtils.getCellData(1, 1));
	}

	public void preencherSenha(AndroidDriver<WebElement> driver, int linha) throws Exception {
		driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.RelativeLayout/android.widget.EditText"))
				.sendKeys(ExcelUtils.getCellData(linha, 2));
	}

	public void preencherConfirmarSenha(AndroidDriver<WebElement> driver, int linha) throws Exception {
		driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.RelativeLayout/android.widget.EditText"))
				.sendKeys(ExcelUtils.getCellData(linha, 3));
	}

	public void preencherNome(AndroidDriver<WebElement> driver, int linha) throws Exception {
		driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.EditText"))
				.sendKeys(ExcelUtils.getCellData(linha, 4));
	}

	public void preencherSobreNome(AndroidDriver<WebElement> driver, int linha) throws Exception {
		driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.EditText"))
				.sendKeys(ExcelUtils.getCellData(linha, 5));
	}

	public void preencherTelefone(AndroidDriver<WebElement> driver, int linha) throws Exception {
		driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText"))
				.sendKeys(ExcelUtils.getCellData(linha, 6));
	}

	public void paisClick(AndroidDriver<WebElement> driver) {
		driver.findElement(By.id("com.Advantage.aShopping:id/textViewCountries")).click();
	}

	public void nomePaisClick(AndroidDriver<WebElement> driver) {
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[9]"))
				.click();
	}

	public void preencherStado(AndroidDriver<WebElement> driver, int linha) throws Exception {
		driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.EditText"))
				.sendKeys(ExcelUtils.getCellData(linha, 10));
	}

	public void preencherEndereco(AndroidDriver<WebElement> driver, int linha) throws Exception {
		driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText"))
				.sendKeys(ExcelUtils.getCellData(linha, 9));
	}

	public void preencherCidade(AndroidDriver<WebElement> driver, int linha) throws Exception {
		driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.EditText"))
				.sendKeys(ExcelUtils.getCellData(linha, 8));
	}

	public void preencherZip(AndroidDriver<WebElement> driver, int linha) throws Exception {
		driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[2]/android.widget.EditText"))
				.sendKeys(ExcelUtils.getCellData(linha, 7));
	}

	public void botaoRegistro(AndroidDriver<WebElement> driver) {
		driver.findElement(By.id("com.Advantage.aShopping:id/buttonRegister")).click();
	}

	public void telefoneClick(AndroidDriver<WebElement> driver) {
		driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText"))
				.click();
	}

	public void estadoClick(AndroidDriver<WebElement> driver) {
		driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.EditText"))
				.click();
	}

	public String getUsuario(int linha) throws Exception {
		return usuario = ExcelUtils.getCellData(linha, 11);
	}

	public String setAtual(AndroidDriver<WebElement> driver) {
		return atual = driver.findElement(By.id("com.Advantage.aShopping:id/textViewMenuUser")).getText();
	}

	public String setFalhaNoAtual(AndroidDriver<WebElement> driver) {
		return atual = driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.TextView"))
				.getText();
	}
}