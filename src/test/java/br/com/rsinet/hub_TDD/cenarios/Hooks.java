package br.com.rsinet.hub_TDD.cenarios;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.hub_TDD.pageObject.DriverManager;
import br.com.rsinet.hub_TDD.pageObject.ElementoCelular;
import br.com.rsinet.hub_TDD.pageObject.PageHome;
import br.com.rsinet.hub_TDD.pageObject.PageProdutos;
import br.com.rsinet.hub_TDD.report.Reports;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Hooks {

	private ExtentReports extent;
	private AndroidDriver<MobileElement> driver;
	private ExtentTest test;
	private PageHome home;
	private PageProdutos produtos;
	private ElementoCelular celular;
	private DriverManager driverManager;

	@BeforeTest
	public void report() {
		extent = Reports.setReport("Todos_Report");
	}

	@BeforeMethod
	public void InicializaApp() throws Exception {
		driverManager = new DriverManager(driver);
		driver = driverManager.getDriver();
		home = new PageHome(driver);
		produtos = new PageProdutos(driver);
		celular = new ElementoCelular(driver);

	}

	@AfterMethod
	public void finalizando(ITestResult result) throws IOException, InterruptedException {
		Reports.statusReported(test, result, driverManager.getDriver());
		Reports.quitExtent(extent);
		driverManager.fecharDriver();
	}

	public PageHome getHome() {
		return home;
	}

	public PageProdutos getProdutos() {
		return produtos;
	}

	public ElementoCelular getCelular() {
		return celular;
	}
}
