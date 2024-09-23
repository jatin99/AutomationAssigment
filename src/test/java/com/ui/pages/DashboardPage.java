package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtil;

public class DashboardPage extends BrowserUtil {

	private static final By USER_NAME_LOCATOR = By.xpath("//a[@class=\"account\"]/span");
	private static final By SEARCH_TEXTBOX_LOCATOR = By.id("search_query_top");

	public DashboardPage(WebDriver wd) {
		super(wd);
		// TODO Auto-generated constructor stub
	}

	public String getUserName() {
		return getVisibleText(USER_NAME_LOCATOR);
	}

	public ProductListPage searchForProduct(String dress) {
		enterText(SEARCH_TEXTBOX_LOCATOR, dress);
		pressEnter(SEARCH_TEXTBOX_LOCATOR);
		return new ProductListPage(getWd());
	}

}
