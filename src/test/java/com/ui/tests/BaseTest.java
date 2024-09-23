package com.ui.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;

public class BaseTest {
	protected WebDriver driver;

	@BeforeClass
	public void setup() {
		String browser = System.getProperty("browser");
		System.out.println("HELLLLOOO");
		if (browser.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("cli")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("--disable-gpu"); // Optional for Windows, improves performance
			options.addArguments("--window-size=1920,1080");
			driver = new ChromeDriver(options);
		}

		else {
			throw new IllegalArgumentException("Browser not supported: " + browser);
		}

	}
}
