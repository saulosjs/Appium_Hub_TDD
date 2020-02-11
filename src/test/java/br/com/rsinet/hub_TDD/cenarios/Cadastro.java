package br.com.rsinet.hub_TDD.cenarios;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_TDD.pageObject.ElementoCelular;
import br.com.rsinet.hub_TDD.pageObject.PageCadastro;
import br.com.rsinet.hub_TDD.pageObject.PageHome;
import io.appium.java_client.android.AndroidDriver;

public class Cadastro {
	private AndroidDriver<WebElement> driver;
	private DesiredCapabilities caps;
	private ElementoCelular celular;
	private PageCadastro cadastro;
	private WebDriverWait wait;
	private int linha;

	@BeforeMethod
	public void inicio() throws Exception {
		caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "AOSP on IA Emulator");
		caps.setCapability("udid", "emulator-5554");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "9");
		caps.setCapability("appPackage", "com.Advantage.aShopping");
		caps.setCapability("appActivity", "com.Advantage.aShopping.SplashActivity");

		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver<WebElement>(url, caps);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10);
		cadastro = new PageCadastro();
		celular = new ElementoCelular(driver);
	}

	@Test
	public void cadastrando() throws Exception {
		linha = 1;
		PageHome.clickMenu(driver);
		PageHome.clickLogin(driver);
		PageHome.clickNovoCadastro(driver);
		cadastro.preencherUsuario(driver, linha);
		cadastro.preencherEmail(driver, linha);
		cadastro.preencherSenha(driver, linha);
		cadastro.preencherConfirmarSenha(driver, linha);
		cadastro.preencherNome(driver, linha);
		cadastro.preencherSobreNome(driver, linha);
		cadastro.preencherTelefone(driver, linha);
		cadastro.telefoneClick(driver);
		celular.clickEnter();
		cadastro.paisClick(driver);

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]"))));
		celular.arrastarTelaParaBaixo();
		celular.arrastarTelaParaBaixo();
		cadastro.nomePaisClick(driver);

		cadastro.estadoClick(driver);
		cadastro.preencherStado(driver, linha);
		celular.clickEnter();
		cadastro.preencherEndereco(driver, linha);
		celular.clickEnter();
		cadastro.preencherCidade(driver, linha);
		cadastro.preencherZip(driver, linha);
		celular.clickEnter();
		celular.arrastarTelaParaBaixo();
		cadastro.botaoRegistro(driver);
		Thread.sleep(2000);
		PageHome.clickMenu(driver);
		AssertJUnit.assertEquals(cadastro.getUsuario(linha), cadastro.setAtual(driver));
	}

	@Test
	public void falhaNoCadastro() throws Exception {
		linha = 2;
		PageHome.clickMenu(driver);
		Thread.sleep(5000);
		PageHome.clickLogin(driver);
		PageHome.clickNovoCadastro(driver);
		cadastro.preencherUsuario(driver, linha);
		cadastro.preencherEmail(driver, linha);
		cadastro.preencherSenha(driver, linha);
		cadastro.preencherConfirmarSenha(driver, linha);
		cadastro.preencherNome(driver, linha);
		cadastro.preencherSobreNome(driver, linha);
		cadastro.preencherTelefone(driver, linha);
		cadastro.telefoneClick(driver);
		celular.clickEnter();
		cadastro.paisClick(driver);

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]"))));
		celular.arrastarTelaParaBaixo();
		celular.arrastarTelaParaBaixo();
		cadastro.nomePaisClick(driver);

		cadastro.estadoClick(driver);
		cadastro.preencherStado(driver, linha);
		celular.clickEnter();
		cadastro.preencherEndereco(driver, linha);
		celular.clickEnter();
		cadastro.preencherCidade(driver, linha);
		cadastro.preencherZip(driver, linha);
		celular.clickEnter();
		celular.arrastarTelaParaBaixo();
		cadastro.botaoRegistro(driver);
		celular.arrastarTelaParaCima();
		celular.arrastarTelaParaCima();
		AssertJUnit.assertEquals(cadastro.getUsuario(linha), cadastro.setFalhaNoAtual(driver));
	}

	@AfterMethod
	public void fim() {
		driver.quit();
	}

}
