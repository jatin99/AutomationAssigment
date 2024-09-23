package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v127.browser.Browser.GetWindowForTargetResponse;

import com.utility.BrowserUtil;

public class PopUpPage extends BrowserUtil {

	public PopUpPage(WebDriver wd) {
		super(wd);
		// TODO Auto-generated constructor stub
	}

	public static final By PROCEED_TO_Checkout_Locator = By.xpath("//a[@title=\"Proceed to checkout\"]");

	public SummaryPage proceedToCheckout() {
		clickOn(PROCEED_TO_Checkout_Locator);
		return new SummaryPage(getWd());
	}
}
