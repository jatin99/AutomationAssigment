package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtil;

public class AddressPage extends BrowserUtil {

	private static final By PROCEED_BUTTON_LOCATOR = By.xpath("//button[@name=\"processAddress\"]");

	public AddressPage(WebDriver wd) {
		super(wd);
		// TODO Auto-generated constructor stub
	}

	public ShippingPage proceed() {
		clickOn(PROCEED_BUTTON_LOCATOR);
		return new ShippingPage(getWd());
	}

}
