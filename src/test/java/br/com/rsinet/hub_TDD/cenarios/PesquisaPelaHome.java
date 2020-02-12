package br.com.rsinet.hub_TDD.cenarios;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.hub_TDD.pageObject.ElementoCelular;
import br.com.rsinet.hub_TDD.pageObject.PageHome;
import br.com.rsinet.hub_TDD.pageObject.PageProdutos;
import br.com.rsinet.hub_TDD.report.Reports;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class PesquisaPelaHome {
	private ElementoCelular celular;
	private PageHome home;
	private PageProdutos produto;
	private int coluna = 3;
	private int linha = 0;
	private String expectativa = "- No results -";
	private ExtentReports extent;
	private ExtentTest test;
	private DesiredCapabilities caps;
	private AndroidDriver<MobileElement> driver;

	@BeforeTest
	public void msd() {
		extent = Reports.setReport("Todos_Report");
	}

	@BeforeMethod
	public void inicio() throws Exception {
//		driverManager = new DriverManager(driver);
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

		home = new PageHome(driver);
		celular = new ElementoCelular(driver);
		produto = new PageProdutos(driver);
	}

	@Test
	public void pesquisaComSucesso() throws Exception {
		test = Reports.createTest("SucessoNaPesquisaPelaHome");
		celular.procuraTexto(coluna, linha);
		linha = 1;
		celular.procuraTexto(coluna, linha);
		assertEquals(produto.asserto(coluna, linha), produto.getNomeProduto());
	}

	@Test
	public void pesquisaComFalha() throws Exception {
		test = Reports.createTest("FalhaNaPesquisaPelaHome");
		home.laptopsClick();
		Thread.sleep(2000);
		produto.filtroClick();
		produto.sistemClick();
		produto.chromeOSClick();
		produto.sistemClick();
		produto.processorClick();
		produto.amdClick();
		produto.processorClick();
		produto.applyClick();
		Assert.assertEquals(expectativa, produto.getResutado());
	}

	@AfterMethod
	public void finalizando(ITestResult result) throws IOException, InterruptedException {
		Reports.statusReported(test, result, driver);
		Reports.quitExtent(extent);
		driver.quit();
	}

}
