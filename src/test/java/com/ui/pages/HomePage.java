package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtil;
import com.utility.Env;
import com.utility.TestUtility;

public class HomePage extends BrowserUtil {

	private static final By SIGN_LINK_LOCATOR = By.xpath("//a[@class=\"login\"]");

	public HomePage(WebDriver wd) {
		super(wd);
		goToWebSite(TestUtility.readProperty(Env.QA, "APP_URL"));
		viewInFullScreen();

	}

	public LoginPage goToSignInPage() {
		clickOn(SIGN_LINK_LOCATOR);
		return new LoginPage(getWd());
	}
}
