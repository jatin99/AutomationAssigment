package com.utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.Locator;

import com.ui.pojo.DashboardTablePOJO;

public abstract class BrowserUtil {
	private WebDriver wd;
	private static WebDriver screenShotWd;
	private WebDriverWait wait;

	public WebDriver getWd() {
		return wd;
	}

	public BrowserUtil(WebDriver wd) {
		super();
		this.wd = wd;
		screenShotWd = wd;
		wait = new WebDriverWait(wd, Duration.ofSeconds(30));
	}

	public void goToWebSite(String url) {
		wd.get(url);

	}

	public void viewInFullScreen() {
		wd.manage().window().maximize();
	}

	public void enterText(By locator, String textToEnter) {

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.clear();
		element.sendKeys(textToEnter);
	}

	public void pressEnter(By locator) {

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.sendKeys(Keys.ENTER);
	}

	public void clickOn(By locator) {

		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}
	
	public void clickOnCheckBox(By locator) {

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.click();
	}


	public String getVisibleText(By locator) {

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		String visibleData = element.getText();
		return visibleData;
	}

	public List<WebElement> getAllElements(By locator) {

		List<WebElement> elementsList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		return elementsList;

	}

	public void findButtonAndClick(List<WebElement> elementsList, int index, By locator) {

		elementsList.get(index).findElement(locator).click();

	}

	public void sleepFor(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void selectFromDropDownByValue(By locator, String value) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		Select select = new Select(element);
		select.selectByValue(value);
	}

	public static String takeScreenShot(String testName) {
		TakesScreenshot takesScreenshot = (TakesScreenshot) screenShotWd; // TC
		File screenShotData = takesScreenshot.getScreenshotAs(OutputType.FILE); // 1010111 111111
		File reportDirectory = new File(System.getProperty("user.dir") + "/screenshots");
		try {
			FileUtils.forceMkdir(reportDirectory);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String pathname = System.getProperty("user.dir") + "/screenshots//" + testName + ".png";
		File myFile = new File(pathname);
		try {
			myFile.createNewFile();
			FileUtils.copyFile(screenShotData, myFile); // APACHE COMMON
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pathname;
	}

	public void acceptAlert() {
		Alert myAlert = wd.switchTo().alert();
		myAlert.accept();
	}

	public String getTextFromAlert() {
		Alert myAlert = wd.switchTo().alert();
		String data = myAlert.getText();
		return data;
	}

	public void dismissAlert() {
		Alert myAlert = wd.switchTo().alert();
		myAlert.dismiss();
	}

	public void switchToFrame(String frameIdOrName) {
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIdOrName));

	}

	public void switchToFrame(int frameIndex) {
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));

	}

}
