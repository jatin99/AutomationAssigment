package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public abstract class TestUtility {

	public static String readProperty(String env, String key) {
		File file = new File(System.getProperty("user.dir") + "//config//" + env + ".properties");
		FileReader reader = null;
		Properties properties = new Properties();
		try {
			reader = new FileReader(file);
			properties.load(reader);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return properties.getProperty(key);
	}

	public static String readProperty(Env env, String key) {
		File file = new File(System.getProperty("user.dir") + "//config//" + env + ".properties");
		FileReader reader = null;
		Properties properties = new Properties();
		try {
			reader = new FileReader(file);
			properties.load(reader);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return properties.getProperty(key);
	}

	/**
	 * Utility Method for reading the excel file to pass to dataprovider method
	 * 
	 * @return String [][]
	 * @throws IOException
	 */
	public static String[][] readExcelFile() throws IOException {

		XSSFWorkbook myWorkbook = new XSSFWorkbook(System.getProperty("user.dir") + "//testData//LoginExcel.xlsx");
		XSSFSheet mySheet = myWorkbook.getSheetAt(0);
		int lastIndexOfRow = mySheet.getLastRowNum();
		XSSFRow myHeader = mySheet.getRow(0);
		int totalNumberOfCols = myHeader.getLastCellNum();
		System.out.println("Last Index of Row is" + lastIndexOfRow);
		System.out.println("total Number of Cols is " + totalNumberOfCols);

		String myData[][] = new String[lastIndexOfRow][totalNumberOfCols];
		XSSFRow myRow;
		XSSFCell myCell;
		for (int rowIndex = 1; rowIndex <= lastIndexOfRow; rowIndex++) {
			for (int colIndex = 0; colIndex < totalNumberOfCols; colIndex++) {
				myRow = mySheet.getRow(rowIndex);
				myCell = myRow.getCell(colIndex);
				myData[rowIndex - 1][colIndex] = myCell.getStringCellValue();

			}
		}

		return myData;
	}

	public static String getTime() {
		Date date = new Date();
		System.out.println(date.toString());

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY HH-mm");
		String formatedDate = sdf.format(date);

		return formatedDate;
	}

}
