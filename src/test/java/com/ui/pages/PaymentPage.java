package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtil;

public class PaymentPage extends BrowserUtil {

	private By bankWireLocator = By.xpath("//a[@title='Pay by bank wire']");
	private By confirmOrderButtonLocator = By.xpath("//button[@class='button btn btn-default button-medium']");
	private By confirmationMessage = By.xpath("//p[contains(text(),'complete.')]");

	public PaymentPage(WebDriver wd) {
		super(wd);
		// TODO Auto-generated constructor stub
	}

	public String proceedWithBankWire() {
		clickOn(bankWireLocator);
		clickOn(confirmOrderButtonLocator);
		return getVisibleText(confirmationMessage);

	}

}
