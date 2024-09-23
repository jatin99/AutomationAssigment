package com.ui.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;

public class InvalidCredsLoginTest extends BaseTest {
	private LoginPage loginPage;

	@BeforeMethod(description = "Setup the browser and load the login page", alwaysRun = true)
	public void setUp() {

		loginPage = new HomePage(driver).goToSignInPage();
	}

	@Test(description = "Verify if an invalid user sees an error message", groups = {
			"smoke" }, retryAnalyzer = com.listeners.ReRunTest.class)
	public void shouldShowErrorMessageForInvalidLogin() {
		String expectedErrorMessage = "Authentication failed.";
		String actualErrorMessage = loginPage.doLoginWithInValidCred("soumitapaul19@gmail.com", "Pass1")
				.getErrorMessage();

		Assert.assertEquals(actualErrorMessage, expectedErrorMessage,
				"The error message did not match the expected message.");
	}

}
