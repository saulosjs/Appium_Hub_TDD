package br.com.rsinet.hub_TDD.pageObject;

import org.openqa.selenium.By;

import br.com.rsinet.hub_TDD.excel.Constant;
import br.com.rsinet.hub_TDD.excel.ExcelUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class PageCadastro {
	private static String usuario;
	private static String atual;
	private AndroidDriver<MobileElement> driver;

	public PageCadastro(AndroidDriver<MobileElement> driver) throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha1");
		this.driver = driver;
	}

	public void preencherUsuario(int linha) throws Exception {
		driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.EditText"))
				.sendKeys(ExcelUtils.getCellData(linha, 0));
	}

	public void preencherEmail(int linha) throws Exception {
		driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.EditText"))
				.sendKeys(ExcelUtils.getCellData(linha, 1));
	}

	public void clickEmail() throws Exception {
		driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.EditText"))
				.click();
	}

	public void preencherSenha(int linha) throws Exception {
		driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.RelativeLayout/android.widget.EditText"))
				.sendKeys(ExcelUtils.getCellData(linha, 2));
	}

	public void preencherConfirmarSenha(int linha) throws Exception {
		driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.RelativeLayout/android.widget.EditText"))
				.sendKeys(ExcelUtils.getCellData(linha, 3));
	}

	public void preencherNome(int linha) throws Exception {
		driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.EditText"))
				.sendKeys(ExcelUtils.getCellData(linha, 4));
	}

	public void preencherSobreNome(int linha) throws Exception {
		driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.EditText"))
				.sendKeys(ExcelUtils.getCellData(linha, 5));
	}

	public void preencherTelefone(int linha) throws Exception {
		driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText"))
				.sendKeys(ExcelUtils.getCellData(linha, 6));
	}

	public void paisClick() {
		driver.findElement(By.id("com.Advantage.aShopping:id/textViewCountries")).click();
	}

	public void nomePaisClick() {
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[9]"))
				.click();
	}

	public void preencherStado(int linha) throws Exception {
		driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.EditText"))
				.sendKeys(ExcelUtils.getCellData(linha, 10));
	}

	public void preencherEndereco(int linha) throws Exception {
		driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText"))
				.sendKeys(ExcelUtils.getCellData(linha, 9));
	}

	public void preencherCidade(int linha) throws Exception {
		driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.EditText"))
				.sendKeys(ExcelUtils.getCellData(linha, 8));
	}

	public void preencherZip(int linha) throws Exception {
		driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[2]/android.widget.EditText"))
				.sendKeys(ExcelUtils.getCellData(linha, 7));
	}

	public void botaoRegistro() {
		driver.findElement(By.id("com.Advantage.aShopping:id/buttonRegister")).click();
	}

	public void telefoneClick() {
		driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText"))
				.click();
	}

	public void estadoClick() {
		driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.EditText"))
				.click();
	}

	public String getUsuario(int linha) throws Exception {
		return usuario = ExcelUtils.getCellData(linha, 0);
	}

	public String setAtual() {
		return atual = driver.findElement(By.id("com.Advantage.aShopping:id/textViewMenuUser")).getText();
	}

	public String setFalhaNoAtual() {
		return atual = driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.TextView"))
				.getText();
	}
}