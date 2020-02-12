package br.com.rsinet.hub_TDD.cenarios;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Cadastro {
	private AndroidDriver<MobileElement> driver;
	private DesiredCapabilities caps;
	private ElementoCelular celular;
	private PageCadastro cadastro;
	private WebDriverWait wait;
	private int linha;
	private PageHome home;

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
		driver = new AndroidDriver<MobileElement>(url, caps);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10);
		cadastro = new PageCadastro(driver);
		celular = new ElementoCelular(driver);
		home = new PageHome(driver);
	}

	@Test
	public void cadastrando() throws Exception {
		linha = 1;
		home.clickMenu();
		home.clickLogin();
		home.clickNovoCadastro();
		cadastro.preencherUsuario(linha);
		cadastro.preencherEmail(linha);
		cadastro.preencherSenha(linha);
		cadastro.preencherConfirmarSenha(linha);
		cadastro.preencherNome(linha);
		cadastro.preencherSobreNome(linha);
		cadastro.preencherTelefone(linha);
		cadastro.telefoneClick();
		celular.clickEnter();
		cadastro.paisClick();

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]"))));
		celular.arrastarTelaParaBaixo();
		celular.arrastarTelaParaBaixo();
		cadastro.nomePaisClick();

		cadastro.estadoClick();
		cadastro.preencherStado(linha);
		celular.clickEnter();
		cadastro.preencherEndereco(linha);
		celular.clickEnter();
		cadastro.preencherCidade(linha);
		cadastro.preencherZip(linha);
		celular.clickEnter();
		celular.arrastarTelaParaBaixo();
		cadastro.botaoRegistro();
		Thread.sleep(2000);
		home.clickMenu();
		AssertJUnit.assertEquals(cadastro.getUsuario(linha), cadastro.setAtual());
	}

	@Test
	public void falhaNoCadastro() throws Exception {
		linha = 2;
		home.clickMenu();
		home.clickLogin();
		home.clickNovoCadastro();
		cadastro.preencherUsuario(linha);
		cadastro.preencherEmail(linha);
		cadastro.preencherSenha(linha);
		cadastro.preencherConfirmarSenha(linha);
		cadastro.preencherNome(linha);
		cadastro.preencherSobreNome(linha);
		cadastro.preencherTelefone(linha);
		cadastro.telefoneClick();
		celular.clickEnter();
		cadastro.paisClick();

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]"))));
		celular.arrastarTelaParaBaixo();
		celular.arrastarTelaParaBaixo();
		cadastro.nomePaisClick();

		cadastro.estadoClick();
		cadastro.preencherStado(linha);
		celular.clickEnter();
		cadastro.preencherEndereco(linha);
		celular.clickEnter();
		cadastro.preencherCidade(linha);
		cadastro.preencherZip(linha);
		celular.clickEnter();
		celular.arrastarTelaParaBaixo();
		cadastro.botaoRegistro();
		AssertJUnit.assertEquals(cadastro.getUsuario(linha), cadastro.setFalhaNoAtual());
	}

	@AfterMethod
	public void fim() {
		driver.quit();
	}

}
