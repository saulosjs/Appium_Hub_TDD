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
import br.com.rsinet.hub_TDD.report.Reports;
import br.com.rsinet.hub_TDD.screenObject.DriverManager;
import br.com.rsinet.hub_TDD.screenObject.ElementoCelular;
import br.com.rsinet.hub_TDD.screenObject.ScreenHome;
import br.com.rsinet.hub_TDD.screenObject.ScreenProdutos;

public class PesquisaPelaLupa {
	private ElementoCelular celular;
	private ScreenHome home;
	private ScreenProdutos produto;
	private int coluna;
	private ExtentReports extent;
	private ExtentTest test;
	private DriverManager driverManager;

	@BeforeTest
	public void msd() {
		extent = Reports.setReport("Todos_Report");
	}

	@BeforeMethod
	public void inicio() throws Exception {
		driverManager = new DriverManager();

		home = new ScreenHome(driverManager.getDriver());
		celular = new ElementoCelular(driverManager.getDriver());
		produto = new ScreenProdutos(driverManager.getDriver());
	}

	@Test
	public void pesquisaComFalha() throws Exception {
		test = Reports.createTest("FalhaNaPesquisaPelaLupa");
		coluna = 11;
		home.textLupa(coluna);
		home.imagemLupa();
		assertEquals("- No results for \"corinthians\" -", produto.getResutado());
	}

	@Test
	public void pesquisaComSucesso() throws Exception {
		test = Reports.createTest("SucessoNaPesquisaPelaLupa");
		coluna = 10;
		home.textLupa(coluna);
		home.imagemLupa();
		celular.procuraTexto(coluna, 1);
		assertEquals(ExcelUtils.getCellData(coluna, 1), produto.getNomeProduto());
	}

	@AfterMethod
	public void finalizando(ITestResult result) throws IOException, InterruptedException {
		Reports.statusReported(test, result, driverManager.getDriver());
		Reports.quitExtent(extent);
		driverManager.fecharDriver();
	}

}
