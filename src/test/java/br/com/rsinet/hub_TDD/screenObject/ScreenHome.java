package br.com.rsinet.hub_TDD.screenObject;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_TDD.excel.Constant;
import br.com.rsinet.hub_TDD.excel.ExcelUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ScreenHome {
	private AndroidDriver<MobileElement> driver;
	private WebDriverWait wait;

	public ScreenHome(AndroidDriver<MobileElement> driver) throws Exception {
		this.driver = driver;
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha2");
		wait = new WebDriverWait(driver, 10);
	}

	public void esperaPhone() {
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\\\"Home Page\\\"]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[2]/android.widget.ImageView"))));
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
