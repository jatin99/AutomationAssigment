package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtil;

public class CustomerInfoPAge extends BrowserUtil {
	private static final By ADDRESS_TEXT_BOX_LOCATOR = By.id("address1");
	private static final By CITY_TEXT_BOX_LOCATOR = By.id("city");
	private static final By POST_CODE_TEXT_BOX_LOCATOR = By.id("postcode");
	private static final By PHONE_TEXT_BOX_LOCATOR = By.id("phone");
	private static final By PHONE_MOBILE_TEXT_BOX_LOCATOR = By.id("phone_mobile");
	private static final By STATE_DROPDOWN_LOCATOR = By.id("id_state");
	private static final By SUBMIT_BUTTON_LOCATOR = By.id("submitAddress");

	public CustomerInfoPAge(WebDriver wd) {
		super(wd);
		// TODO Auto-generated constructor stub
	}

	public AddressPage fillAddress(String address, String city, String postcode, String phoneNumber,
			String mobileNumber, String state) {
		enterText(ADDRESS_TEXT_BOX_LOCATOR, address);
		enterText(CITY_TEXT_BOX_LOCATOR, city);
		enterText(POST_CODE_TEXT_BOX_LOCATOR, postcode);
		enterText(PHONE_TEXT_BOX_LOCATOR, phoneNumber);
		enterText(PHONE_MOBILE_TEXT_BOX_LOCATOR, mobileNumber);
		selectFromDropDownByValue(STATE_DROPDOWN_LOCATOR, state);
		clickOn(SUBMIT_BUTTON_LOCATOR);
		return new AddressPage(getWd());
	}

}
