package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtil;

public class ProductListPage extends BrowserUtil {

	public ProductListPage(WebDriver wd) {
		super(wd);
	}

	private static final By PRODUCTS_LIST_LOCATOR = By.xpath("//ul[@class=\"product_list grid row\"]/li");
	private static final By MORE_BUTTON_LOCATOR = By.xpath(".//h5[@itemprop=\"name\"]/a");

	public int totalProductsAvailable() {
		return getAllElements(PRODUCTS_LIST_LOCATOR).size();
	}

	public ProductDetailsPage clickOnProduct(int index) {
		findButtonAndClick(getAllElements(PRODUCTS_LIST_LOCATOR), index, MORE_BUTTON_LOCATOR);
		return new ProductDetailsPage(getWd());
	}
}
