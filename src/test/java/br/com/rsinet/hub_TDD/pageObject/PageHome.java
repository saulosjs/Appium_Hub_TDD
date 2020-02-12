package br.com.rsinet.hub_TDD.pageObject;

import org.openqa.selenium.By;

import br.com.rsinet.hub_TDD.excel.Constant;
import br.com.rsinet.hub_TDD.excel.ExcelUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class PageHome {
	private AndroidDriver<MobileElement> driver;

	public PageHome(AndroidDriver<MobileElement> driver) throws Exception {
		this.driver = driver;
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha2");
	}

	public void clickMenu() {
		driver.findElement(By.id("com.Advantage.aShopping:id/imageViewMenu")).click();
	}

	public void clickLogin() {
		driver.findElement(By.id("com.Advantage.aShopping:id/textViewMenuUser")).click();
	}

	public void clickNovoCadastro() {
		driver.findElement(By.id("com.Advantage.aShopping:id/textViewDontHaveAnAccount")).click();
	}

	public void laptopsClick() {
		driver.findElement(By.id("com.Advantage.aShopping:id/textViewCategory")).click();
	}

	public void textLupa(int coluna) throws Exception {
		driver.findElement(By.id("com.Advantage.aShopping:id/editTextSearch"))
				.sendKeys(ExcelUtils.getCellData(coluna, 0));
	}

	public void imagemLupa() throws Exception {
		driver.findElement(By.id("com.Advantage.aShopping:id/imageViewSearch")).click();
	}

}
