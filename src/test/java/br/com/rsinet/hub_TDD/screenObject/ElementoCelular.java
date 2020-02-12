package br.com.rsinet.hub_TDD.screenObject;

import br.com.rsinet.hub_TDD.excel.Constant;
import br.com.rsinet.hub_TDD.excel.ExcelUtils;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class ElementoCelular {
	private AndroidDriver driver;
	private static TouchAction moverTela;

	public ElementoCelular(AndroidDriver driver) throws Exception {
		this.driver = driver;
		moverTela = new TouchAction(driver);
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha2");
	}

	public void clickEnter() {
		moverTela.tap(PointOption.point(932, 1691)).perform();
	}

	public void arrastarTelaParaBaixo() {
		moverTela.press(PointOption.point(815, 1623)).moveTo(PointOption.point(905, 300)).release().perform();
	}

	public void arrastarTelaParaCima() {
		moverTela.press(PointOption.point(844, 489)).moveTo(PointOption.point(847, 1280)).release().perform();
	}

	public void setaVoltarGeral() {
		moverTela.tap(PointOption.point(982, 1687)).perform();
	}

	public void esolherPreco() {
		moverTela.press(PointOption.point(49, 437)).moveTo(PointOption.point(962, 437)).release().perform();
	}

	public void procuraTexto(int coluna, int linha) throws Exception {
		String celula = ExcelUtils.getCellData(coluna, linha);
		((FindsByAndroidUIAutomator) driver).findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ celula + "\").instance(0))")
				.click();
	}

}
