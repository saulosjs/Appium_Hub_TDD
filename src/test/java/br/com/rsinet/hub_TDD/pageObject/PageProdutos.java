package br.com.rsinet.hub_TDD.pageObject;

import org.openqa.selenium.By;

import br.com.rsinet.hub_TDD.excel.ExcelUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class PageProdutos {
	private AndroidDriver<MobileElement> driver;

	public PageProdutos(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
	}

	public void filtroClick() {
		driver.findElement(By.id("com.Advantage.aShopping:id/imageViewFilter")).click();
	}

	public void sistemClick() {
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[7]/android.widget.LinearLayout/android.widget.TextView"))
				.click();
	}

	public void chromeOSClick() {
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[8]/android.widget.LinearLayout/android.widget.TextView"))
				.click();
	}

	public void processorClick() {
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[8]/android.widget.LinearLayout/android.widget.TextView"))
				.click();
	}

	public void amdClick() {
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[9]/android.widget.LinearLayout/android.widget.TextView"))
				.click();
	}

	public void applyClick() {
		driver.findElement(By.id("com.Advantage.aShopping:id/textViewApply")).click();
	}

	public String getResutado() {
		return driver.findElement(By.id("com.Advantage.aShopping:id/textViewNoProductsToShow")).getText();
	}

	public String asserto(int coluna, int linha) throws Exception {
		return ExcelUtils.getCellData(coluna, linha);
	}

	public String getNomeProduto() {
		return driver.findElement(By.id("com.Advantage.aShopping:id/textViewProductName")).getText();
	}

}
