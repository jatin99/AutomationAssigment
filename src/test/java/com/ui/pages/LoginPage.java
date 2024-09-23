package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtil;
import com.utility.Env;
import com.utility.TestUtility;

public final class LoginPage extends BrowserUtil {

	private static final By USER_NAME_TEXTBOX_LOCATOR = By.id("email");
	private static final By PASSWORD_TEXTBOX_LOCATOR = By.id("passwd");
	private static final By SIGN_BUTTON_LOCATOR = By.id("SubmitLogin");
	
	private static final By ERROR_MSG_LOCATOR = By.xpath("//p[contains(text(),\"error\")]/../ol/li");

	private WebDriver wd;

	public LoginPage(WebDriver wd) {
		super(wd);
		// TODO Auto-generated constructor stub
		

	}
	
	public DashboardPage doLoginWithValidCred(String email, String password) {
		enterText(USER_NAME_TEXTBOX_LOCATOR, email);
		enterText(PASSWORD_TEXTBOX_LOCATOR, password);
		clickOn(SIGN_BUTTON_LOCATOR);
		return new DashboardPage(getWd());
		
	}
	
	public LoginPage doLoginWithInValidCred(String email, String password) {
		enterText(USER_NAME_TEXTBOX_LOCATOR, email);
		enterText(PASSWORD_TEXTBOX_LOCATOR, password);
		clickOn(SIGN_BUTTON_LOCATOR);
		return new LoginPage(getWd());
		
	}

	public String getErrorMessage() {
		return getVisibleText(ERROR_MSG_LOCATOR);
	}
}
