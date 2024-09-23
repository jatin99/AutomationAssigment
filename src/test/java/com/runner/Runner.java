package com.runner;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlPackage;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlSuite.ParallelMode;
import org.testng.xml.XmlTest;
//Entry the point!!!

public class Runner {
	public static String componentType, testType, name;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		componentType = args[0]; // api ui mobile
		testType = args[1]; // sanity smoke e2e reg
		name = componentType + "-" + testType;

		System.out.println(componentType);
		System.out.println(testType);

		TestNG testNG = new TestNG();

		XmlSuite suite = new XmlSuite();
		suite.setName("Phoenix Test Suite"); // <suite name="Suite1" verbose="1">
		suite.setVerbose(1);

		XmlTest myTest = new XmlTest(suite);
		myTest.setName(name + "_MyTest"); // <test name="API-Sanity_MyTest">

		// <package name = "com.ui.tests">
		XmlPackage xmlPackage1 = new XmlPackage("com." + componentType + ".tests");
		List<XmlPackage> packageList = new ArrayList<XmlPackage>();
		packageList.add(xmlPackage1);
		myTest.setPackages(packageList);
		; // *************

		/*
		 * 
		 * <test name="API Tests">
		 * 
		 * <packages> <package name="com.ui.tests"></package> </packages> </test>
		 */

		myTest.addIncludedGroup(testType); //
//		myTest.setParallel(ParallelMode.METHODS);

		List<XmlTest> myListTests = new ArrayList<XmlTest>();
		myListTests.add(myTest);
		suite.setTests(myListTests);

		List<XmlSuite> suiteList = new ArrayList<XmlSuite>();
		suiteList.add(suite);
		testNG.setXmlSuites(suiteList);

		testNG.run(); // Start the execution of your tests....
	}

}
