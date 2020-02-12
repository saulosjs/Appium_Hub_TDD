package br.com.rsinet.hub_TDD.cenarios;

import static org.testng.AssertJUnit.assertEquals;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.hub_TDD.excel.ExcelUtils;
import br.com.rsinet.hub_TDD.pageObject.ElementoCelular;
import br.com.rsinet.hub_TDD.pageObject.PageHome;
import br.com.rsinet.hub_TDD.pageObject.PageProdutos;
import br.com.rsinet.hub_TDD.report.Reports;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class PesquisaPelaLupa2 {
	private ElementoCelular celular;
	private PageHome home;
	private PageProdutos produto;
	private int coluna;
	private ExtentReports extent;
	private ExtentTest test;
//	private DriverManager driverManager;
	private AndroidDriver<MobileElement> driver;
	private DesiredCapabilities caps;

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
	public void pesquisaComFalha() throws Exception {
		test = Reports.createTest("FalhaNaPesquisaPelaLupa");
		coluna = 7;
		home.textLupa(coluna);
		home.imagemLupa();
		assertEquals("- No results for \"apple\" -", produto.getResutado());
	}

	@Test
	public void pesquisaComSucesso() throws Exception {
		test = Reports.createTest("SucessoNaPesquisaPelaLupa");
		coluna = 6;
		home.textLupa(coluna);
		home.imagemLupa();
		celular.procuraTexto(coluna, 1);
		assertEquals(ExcelUtils.getCellData(coluna, 1), produto.getNomeProduto());
	}

	@AfterMethod
	public void finalizando(ITestResult result) throws IOException, InterruptedException {
		Reports.statusReported(test, result, driver);
		Reports.quitExtent(extent);
		driver.quit();
	}

}
