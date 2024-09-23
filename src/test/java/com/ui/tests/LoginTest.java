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

public class LoginTest extends BaseTest {
	private LoginPage loginPage;

	@BeforeMethod(description = "Setup the browser and load the login page", alwaysRun = true)
	public void setUp() {

		loginPage = new HomePage(driver).goToSignInPage();
	}

	@Test(description = "Verify if a valid user is able to login", groups = {
			"smoke" }, dataProviderClass = com.dataproviders.LoginDataProvider.class, dataProvider = "loginExcel")
	public void shouldLoginWithValidCredentials(String username, String password) {
		String expectedUserName = "Soumita Paul";
		String actualUserName = loginPage.doLoginWithValidCred(username, password).getUserName();

		Assert.assertEquals(actualUserName, expectedUserName,
				"The logged-in user's name did not match the expected username.");
	}

	

	
}
