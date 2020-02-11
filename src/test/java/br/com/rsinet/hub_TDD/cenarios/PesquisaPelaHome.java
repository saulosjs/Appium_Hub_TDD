package br.com.rsinet.hub_TDD.cenarios;

import static org.junit.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.hub_TDD.report.Reports;

public class PesquisaPelaHome extends Hooks {

	private int coluna = 3;
	private int linha = 0;
	private String expectativa = "- No results -";
	private ExtentReports extent;
	private ExtentTest test;

	@Test
	public void pesquisaComSucesso() throws Exception {
		test = Reports.createTest("SucessoNaPesquisaPelaHome");
		getCelular().procuraTexto(coluna, linha);
		linha = 1;
		getCelular().procuraTexto(coluna, linha);
		assertEquals(getProdutos().asserto(coluna, linha), getProdutos().getNomeProduto());
	}

	@Test
	public void pesquisaComFalha() throws Exception {
		test = Reports.createTest("FalhaNaPesquisaPelaHome");
		getHome().laptopsClick();
		Thread.sleep(2000);
		getProdutos().filtroClick();
		getProdutos().sistemClick();
		getProdutos().chromeOSClick();
		getProdutos().sistemClick();
		getProdutos().processorClick();
		getProdutos().amdClick();
		getProdutos().processorClick();
		getProdutos().applyClick();
		Assert.assertEquals(expectativa, getProdutos().getResutado());
	}

}
