package com.ui.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;
import com.ui.pages.DashboardPage;

public class ProductSearchingTest extends BaseTest {

	private DashboardPage dashboardPage;
	private static final String VALID_EMAIL = "soumitapaul19@gmail.com";
	private static final String VALID_PASSWORD = "Pass123";
	private static final String PRODUCT_NAME = "Printed Summer Dress";
	private static final String EXPECTED_SUCCESS_MESSAGE = "Your order on My Store is complete.";

	@BeforeMethod(description = "Setup the browser and perform login", alwaysRun = true)
	public void setUp() {

		dashboardPage = new HomePage(driver).goToSignInPage().doLoginWithValidCred(VALID_EMAIL, VALID_PASSWORD);
	}

	@Test(description = "Verify if user is able to buy a product", groups = {
			"smoke" }, retryAnalyzer = com.listeners.ReRunTest.class)
	public void shouldBuyProductSuccessfully() {
		String message = dashboardPage.searchForProduct(PRODUCT_NAME).clickOnProduct(0).changeColourToBlack()
				.addProductToCart().proceedToCheckout().clickOnProceed().proceed().acceptTermsAndCondition()
				.proceedWithBankWire();
		Assert.assertEquals(message, EXPECTED_SUCCESS_MESSAGE);
	}

}
