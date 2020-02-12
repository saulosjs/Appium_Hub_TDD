package br.com.rsinet.hub_TDD.report;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ScreenShot {

	public static String getTimeStamp() {
		return new SimpleDateFormat("dd_MM_yyyy HH.mm.ss").format(new Date());
	}

	public static String gerarScreenShot(AndroidDriver<MobileElement> driver, String nome) {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destino = System.getProperty("user.dir") + "/target/reportScreenshot/" + nome + "-" + getTimeStamp()
				+ ".png";
		try {
			FileUtils.copyFile(file, new File(destino));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destino;
	}
}
