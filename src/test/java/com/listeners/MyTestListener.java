package com.listeners;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utility.BrowserUtil;
import com.utility.TestUtility;

public class MyTestListener implements ITestListener {

	private ExtentReports extentReports;
	private ExtentTest extentTest;
	private ExtentSparkReporter extentSparkReporter;

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(
				"******************* Test Started: " + result.getMethod().getMethodName() + " *******************");
		System.out.println("Description: " + result.getMethod().getDescription());
		System.out.println("Test Groups: " + Arrays.toString(result.getMethod().getGroups()));

		extentTest = extentReports.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(
				"******************* Test Passed: " + result.getMethod().getMethodName() + " *******************");
		extentTest.pass("Test passed successfully");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(
				"******************* Test Failed: " + result.getMethod().getMethodName() + " *******************");
		extentTest.fail("Test failed");

		// Capture the exception details in the report
		extentTest.fail(result.getThrowable());

		String screenshotPath = BrowserUtil.takeScreenShot(result.getMethod().getMethodName());
		extentTest.addScreenCaptureFromPath(screenshotPath);

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(
				"******************* Test Skipped: " + result.getMethod().getMethodName() + " *******************");
		extentTest.skip("Test Skipped");
		extentTest.skip(result.getThrowable());
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("******************* Test Suite Started: " + context.getName() + " *******************");

		File reportDirectory = new File(System.getProperty("user.dir") + "/report");
		if (!reportDirectory.exists()) {
			try {
				FileUtils.forceMkdir(reportDirectory);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		extentSparkReporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "/report/report_" + TestUtility.getTime() + ".html");
		extentSparkReporter.config().setReportName("Automation Test Results");
		extentSparkReporter.config().setDocumentTitle("Test Execution Report");

		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);

		extentReports.setSystemInfo("Tester", "Soumita");
		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		extentReports.setSystemInfo("Browser",System.getProperty("browser")); 
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("******************* Test Suite Finished: " + context.getName() + " *******************");

		extentReports.flush();
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}
}
