package br.com.rsinet.hub_TDD.cenarios;

import static org.testng.AssertJUnit.assertEquals;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.hub_TDD.excel.ExcelUtils;
import br.com.rsinet.hub_TDD.pageObject.DriverManager;
import br.com.rsinet.hub_TDD.pageObject.ElementoCelular;
import br.com.rsinet.hub_TDD.pageObject.PageHome;
import br.com.rsinet.hub_TDD.pageObject.PageProdutos;
import br.com.rsinet.hub_TDD.report.Reports;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class PesquisaPelaLupa {
	private ElementoCelular celular;
	private PageHome home;
	private PageProdutos produto;
	private int coluna;
	private ExtentReports extent;
	private ExtentTest test;
	private DriverManager driverManager;
	private AndroidDriver<MobileElement> driver;

	@BeforeTest
	public void report() {
		extent = Reports.setReport("Todos_Report");
	}

	@BeforeMethod
	public void inicio() throws Exception {
		driverManager = new DriverManager(driver);
		driver = driverManager.getDriver();
		home = new PageHome(driver);
		celular = new ElementoCelular(driver);
		produto = new PageProdutos(driver);
	}

	@Test
	public void pesquisaComSucesso() throws Exception {
		test = Reports.createTest("SucessoNaPesquisaPelaLupa");
		coluna = 6;
		Thread.sleep(3000);
		home.textLupa(coluna);
		home.imagemLupa();
		celular.procuraTexto(coluna, 1);
		assertEquals(ExcelUtils.getCellData(coluna, 1), produto.getNomeProduto());
	}

	@Test
	public void pesquisaComFalha() throws Exception {
		test = Reports.createTest("FalhaNaPesquisaPelaLupa");
		coluna = 7;
		home.textLupa(coluna);
		home.imagemLupa();
		assertEquals("- No results for \"apple\" -", produto.getResutado());
	}

	@AfterMethod
	public void finalizando(ITestResult result) throws IOException {
		Reports.statusReported(test, result, driver);
		Reports.quitExtent(extent);
		driverManager.fecharDriver();
	}

}
