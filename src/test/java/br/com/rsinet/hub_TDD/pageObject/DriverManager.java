package br.com.rsinet.hub_TDD.pageObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class DriverManager {
	private AndroidDriver<MobileElement> driver;
	private DesiredCapabilities caps;

	public DriverManager(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
	}

	public AndroidDriver<MobileElement> getDriver() throws MalformedURLException {
		if (driver == null)
			driver = createDriver();
		return driver;
	}

	private AndroidDriver<MobileElement> createDriver() throws MalformedURLException {
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
		return driver;
	}

	public void fecharDriver() {
		if (driver == null)
			throw new NullPointerException("Driver null");
		driver.quit();
	}

}
