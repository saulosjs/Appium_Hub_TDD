package br.com.rsinet.hub_TDD.cenarios;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.hub_TDD.report.Reports;
import br.com.rsinet.hub_TDD.screenObject.DriverManager;
import br.com.rsinet.hub_TDD.screenObject.ElementoCelular;
import br.com.rsinet.hub_TDD.screenObject.ScreenCadastro;
import br.com.rsinet.hub_TDD.screenObject.ScreenHome;

public class Cadastro {
	private DriverManager driverManager;
	private ElementoCelular celular;
	private ScreenCadastro cadastro;
	private WebDriverWait wait;
	private int linha;
	private ScreenHome home;
	private ExtentReports extent;
	private ExtentTest test;

	@BeforeTest
	public void msd() {
		extent = Reports.setReport("Todos_Report");
	}

	@BeforeMethod
	public void inicio() throws Exception {
		driverManager = new DriverManager();

		wait = new WebDriverWait(driverManager.getDriver(), 10);
		cadastro = new ScreenCadastro(driverManager.getDriver());
		celular = new ElementoCelular(driverManager.getDriver());
		home = new ScreenHome(driverManager.getDriver());
	}

	@Test
	public void cadastrando() throws Exception {
		test = Reports.createTest("SucessoNoCadastro");
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

		cadastro.esperarPais();
		celular.procuraTexto(linha, 11);

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
		home.esperaPhone();
		home.clickMenu();
		AssertJUnit.assertEquals(cadastro.getUsuario(linha), cadastro.setAtual());
	}

	@Test
	public void falhaNoCadastro() throws Exception {
		test = Reports.createTest("FalhaNoadastro");
		linha = 2;
		home.clickMenu();
		home.clickLogin();
		home.clickNovoCadastro();
		cadastro.preencherEmail(linha);
		cadastro.preencherSenha(linha);
		cadastro.preencherConfirmarSenha(linha);
		cadastro.preencherNome(linha);
		cadastro.preencherSobreNome(linha);
		cadastro.preencherTelefone(linha);
		cadastro.telefoneClick();
		celular.clickEnter();
		cadastro.paisClick();

		cadastro.esperarPais();
		celular.procuraTexto(linha, 11);

		cadastro.estadoClick();
		cadastro.preencherStado(linha);
		celular.clickEnter();
		cadastro.preencherEndereco(linha);
		celular.clickEnter();
		cadastro.preencherCidade(linha);
		cadastro.preencherZip(linha);
		celular.clickEnter();
		celular.procuraTexto(13, 0);
		cadastro.clickEmail();
		AssertJUnit.assertEquals("User name required", cadastro.setFalhaNoAtual());
	}

	@AfterMethod
	public void fim(ITestResult result) throws MalformedURLException, IOException {
		Reports.statusReported(test, result, driverManager.getDriver());
		Reports.quitExtent(extent);
		driverManager.fecharDriver();
	}

}
