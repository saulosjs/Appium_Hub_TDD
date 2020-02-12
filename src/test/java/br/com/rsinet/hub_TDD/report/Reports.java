package br.com.rsinet.hub_TDD.report;

import java.io.IOException;

import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Reports {

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	public static ExtentReports setReport(String nomeReport) {

		htmlReporter = new ExtentHtmlReporter("target/" + nomeReport + ".html");
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Functional Report");

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		return extent;

	}

	public static ExtentTest createTest(String testName) {

		test = extent.createTest(testName);
		return test;

	}

	public static void statusReported(ExtentTest test, ITestResult result, AndroidDriver<MobileElement> driver)
			throws IOException {

		String screenPath = ScreenShot.gerarScreenShot(driver, result.getName());

		if (result.getStatus() == ITestResult.FAILURE) {

			test.log(Status.FAIL, "Caso de teste FAILED: " + result.getName());
			test.log(Status.FAIL, "Caso de teste FAILED: " + result.getThrowable());
			test.addScreenCaptureFromPath(screenPath);

		} else if (result.getStatus() == ITestResult.SKIP) {

			test.log(Status.SKIP, "Caso de teste SKIPPED: " + result.getName());
			test.addScreenCaptureFromPath(screenPath);

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Caso de teste PASSED: " + result.getName());
			test.addScreenCaptureFromPath(screenPath);
		}
	}

	public static void quitExtent(ExtentReports extent) {

		extent.flush();
	}
}
