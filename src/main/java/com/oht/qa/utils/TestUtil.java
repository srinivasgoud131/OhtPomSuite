package com.oht.qa.utils;

import java.util.ArrayList;
import java.util.Hashtable;

public class TestUtil {
	public static long Page_Load_Time=10;
	public static long Implicit_wait=20;
	
	static Xls_Reader reader;
	
	public static Object[][] getDataFromExcel() {
		reader = new Xls_Reader("C:\\Users\\srinivas\\Desktop\\OHTTestData.xlsx");
		String sheetName = "RegTestData";
		int rows = reader.getRowCount(sheetName);
		int cols = reader.getColumnCount(sheetName);

		Object[][] testData = new Object[rows - 1][1];
		Hashtable<String, String> table = null;
		for (int rowNum = 2; rowNum <=rows; rowNum++) {
			table = new Hashtable<String, String>();
			for (int colNum = 0; colNum < cols; colNum++) {

				table.put(reader.getCellData(sheetName, colNum, 1), reader.getCellData(sheetName, colNum, rowNum));
//				testData[rowNum-2][colNum] = reader.getCellData(sheetName, colNum, rowNum);
				testData[rowNum-2][0] = table; 
			}
		}
		return testData;
	}
}