package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtil;

public class SummaryPage extends BrowserUtil {
	public static final By PROCEED_TO_Checkout_Locator = By.xpath("//p/a[@title=\"Proceed to checkout\"]");

	public SummaryPage(WebDriver wd) {
		super(wd);
		// TODO Auto-generated constructor stub
	}

	public AddressPage clickOnProceed() {
		clickOn(PROCEED_TO_Checkout_Locator);
		return new AddressPage(getWd());

	}

}
