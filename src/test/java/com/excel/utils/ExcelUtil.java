package com.excel.utils;

import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	public ExcelUtil() {

	}

	public static void main(String[] args) throws Exception {

		// Insantiate empty DataSheet

		DataSheet dataSheet1 = new DataSheet("EDI_850_Segment_Configuration.xlsx", "Sheet1");

//		System.out.println("Cell value - " + dataSheet.getCellValue("Description", 2));
		System.out.println("Cell value - " + dataSheet1.getCellValue("Column-2", 0));
		System.out.println("Cell value - " + dataSheet1.getCellValue(0, 0));
		System.out.println("Cell value - " + dataSheet1.getCellValue(0, 8));
		System.out.println("Cell value - " + dataSheet1.getCellValue(8, 0));
		System.out.println("Cell value - " + dataSheet1.getCellValue(8, 1));
		System.out.println("Cell value - " + dataSheet1.getCellValue(8, 2));
		System.out.println("Cell value - " + dataSheet1.getCellValue(8, 3));
		System.out.println("Cell value - " + dataSheet1.getCellValue(8, 4));
		System.out.println("Cell value - " + dataSheet1.getCellValue(8, 6));
		System.out.println("Cell value - " + dataSheet1.getCellValue(8, 7));
		System.out.println("Cell value - " + dataSheet1.getCellValue(8, 8));
		System.out.println("Cell Value - " + dataSheet1.getCellValue("B10"));

		System.out.println("*********************************************************");

		DataSheet dataSheet2 = new DataSheet("EDI_850_Segment_Configuration.xlsx", "Sheet1", true);
		System.out.println("Cell value - " + dataSheet2.getCellValue("Description", 0));
		System.out.println("Cell value - " + dataSheet2.getCellValue(8, 0));
		System.out.println("Cell value - " + dataSheet2.getCellValue(8, 1));
		System.out.println("Cell value - " + dataSheet2.getCellValue(8, 2));
		System.out.println("Cell value - " + dataSheet2.getCellValue(8, 3));
		System.out.println("Cell value - " + dataSheet2.getCellValue(8, 4));
		System.out.println("Cell value - " + dataSheet2.getCellValue(8, 6));
		System.out.println("Cell value - " + dataSheet2.getCellValue(8, 7));
		System.out.println("Cell value - " + dataSheet2.getCellValue(8, 8));
		System.out.println("Cell Value - " + dataSheet2.getCellValue("B10"));
	}
}
