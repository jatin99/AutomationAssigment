package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtil;

public class ProductDetailsPage extends BrowserUtil {

	public ProductDetailsPage(WebDriver wd) {
		super(wd);
	}

	private static final By PRODUCTS_LIST_LOCATOR = By.xpath("//ul[@class=\"product_list grid row\"]/li");
	private static final By MORE_BUTTON_LOCATOR = By.xpath(".//h5[@itemprop=\"name\"]/a");
	private static final By ADD_PRODUCT_LOCATOR = By.xpath("//button[@name=\"Submit\"]");
	private static final By COLOR_LOCATOR = By.xpath("//a[@name=\"Black\"]");

	public int totalProductsAvailable() {
		return getAllElements(PRODUCTS_LIST_LOCATOR).size();
	}

	public void clickOnProduct(int index) {
		findButtonAndClick(getAllElements(PRODUCTS_LIST_LOCATOR), index, MORE_BUTTON_LOCATOR);
	}

	public ProductDetailsPage changeColourToBlack() {
		clickOn(COLOR_LOCATOR);
		clickOn(COLOR_LOCATOR);

		return new ProductDetailsPage(getWd());
	}

	public PopUpPage addProductToCart() {
		clickOn(ADD_PRODUCT_LOCATOR);
		return new PopUpPage(getWd());
	}

}
