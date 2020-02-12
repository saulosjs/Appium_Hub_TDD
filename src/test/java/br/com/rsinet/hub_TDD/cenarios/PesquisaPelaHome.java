package br.com.rsinet.hub_TDD.cenarios;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.hub_TDD.pageObject.DriverManager;
import br.com.rsinet.hub_TDD.pageObject.ElementoCelular;
import br.com.rsinet.hub_TDD.pageObject.PageHome;
import br.com.rsinet.hub_TDD.pageObject.PageProdutos;
import br.com.rsinet.hub_TDD.report.Reports;

public class PesquisaPelaHome {
	private ElementoCelular celular;
	private PageHome home;
	private PageProdutos produto;
	private int coluna = 7;
	private int linha = 0;
	private String expectativa = "- No results -";
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

		home = new PageHome(driverManager.getDriver());
		celular = new ElementoCelular(driverManager.getDriver());
		produto = new PageProdutos(driverManager.getDriver());
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
		Reports.statusReported(test, result, driverManager.getDriver());
		Reports.quitExtent(extent);
		driverManager.fecharDriver();
	}

}
