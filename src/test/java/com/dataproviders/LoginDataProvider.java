package com.dataproviders;

import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;

import com.utility.TestUtility;

public class LoginDataProvider {

	@DataProvider(name = "loginExcel")
	public String[][] loginDP2() throws IOException {
		return TestUtility.readExcelFile();
	}
}
