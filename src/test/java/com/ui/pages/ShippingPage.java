package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtil;

public class ShippingPage extends BrowserUtil {
	private By checkBoxLocator = By.id("uniform-cgv");
	private By checkoutButtonLocator = By.xpath("//button[@name='processCarrier']");

	public ShippingPage(WebDriver wd) {
		super(wd);
		// TODO Auto-generated constructor stub
	}

	public PaymentPage acceptTermsAndCondition() {
		clickOnCheckBox(checkBoxLocator);
		clickOn(checkoutButtonLocator);
		return new PaymentPage(getWd());
	}
}
