package com.excel.utils;

import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataSheet {

	private String name;
	private Map<String, List<Object>> recordsTable;
	private boolean isHeaderEnabled;

	public DataSheet(String filePath, String sheetName) throws Exception {
		this(filePath, sheetName, false);

	}
	/*
	 * public DataSheet(String filePath, String sheetName) throws Exception {
	 * super(); this.name = sheetName; isHeaderEnabled = false;
	 * 
	 * recordsTable = new LinkedHashMap<>();
	 * 
	 * System.out.println("Started Reading file: " + filePath);
	 * 
	 * Workbook workbook = null; FileInputStream fis = null; fis = new
	 * FileInputStream(filePath); workbook = new XSSFWorkbook(fis); Sheet sheet =
	 * workbook.getSheet(sheetName);
	 * 
	 * int firstRowNumber = sheet.getFirstRowNum(); int lastRowNumber =
	 * sheet.getLastRowNum();
	 * 
	 * System.out.println("First row number - " + sheet.getFirstRowNum());
	 * System.out.println("Last row number - " + sheet.getLastRowNum());
	 * 
	 * // Fetch headers and put into the datasheet map
	 * 
	 * int headerCount = sheet.getRow(firstRowNumber) .getFirstCellNum();
	 * 
	 * Row firstRow = sheet.getRow(firstRowNumber);
	 * 
	 * // Fetch headers from the first row and put them into the datasheet records
	 * // table as the map keys
	 * 
	 * { while (headerCount < sheet.getRow(firstRowNumber) .getLastCellNum()) {
	 * 
	 * this.recordsTable.put(cellToString(firstRow.getCell(headerCount)), new
	 * ArrayList<Object>());
	 * 
	 * headerCount++; } }
	 * 
	 * 
	 * String tempColumnName = "Column-";
	 * 
	 * while (headerCount < sheet.getRow(firstRowNumber) .getLastCellNum()) {
	 * 
	 * this.recordsTable.put(tempColumnName + headerCount, new ArrayList<Object>());
	 * 
	 * headerCount++; } tempColumnName = null;
	 * 
	 * System.out.println("Map in datasheet :- " + this.recordsTable.entrySet());
	 * System.out.println("**********************************************");
	 * 
	 * for (int i = firstRowNumber; i <= lastRowNumber; i++) { Row row =
	 * sheet.getRow(i);
	 * 
	 * if (row != null) {
	 * 
	 * int firstColumnNumber = row.getFirstCellNum(); int lastColumnNumber =
	 * row.getLastCellNum(); String tempColName = "Column-";
	 * 
	 * for (int j = firstColumnNumber; j < lastColumnNumber; j++) {
	 * 
	 * this.recordsTable.get(tempColName + j) .add(cellToString(row.getCell(j)));
	 * 
	 * } } }
	 * 
	 * workbook.close(); fis.close();
	 * 
	 * System.out.println("Printing the datasheet :- ");
	 * System.out.println(this.toString()); }
	 */

	public DataSheet(String filePath, String sheetName, boolean isHeaderEnabled) throws Exception {
		super();
		this.name = sheetName;
		this.isHeaderEnabled = isHeaderEnabled;

		recordsTable = new LinkedHashMap<>();

		System.out.println("Started Reading file: " + filePath);

		Workbook workbook = null;
		FileInputStream fis = null;
		fis = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet(sheetName);

		int firstRowNumber = sheet.getFirstRowNum();
		int lastRowNumber = sheet.getLastRowNum();

		System.out.println("First row number - " + sheet.getFirstRowNum());
		System.out.println("Last row number - " + sheet.getLastRowNum());

		// Fetch headers and put into the datasheet map

		int headerCount = sheet.getRow(firstRowNumber)
				.getFirstCellNum();

		Row firstRow = sheet.getRow(firstRowNumber);

		if (this.isHeaderEnabled) {
			// Fetch headers from the first row and put them into the datasheet records
			// table as the map keys
			while (headerCount < sheet.getRow(firstRowNumber)
					.getLastCellNum()) {

				this.recordsTable.put(cellToString(firstRow.getCell(headerCount)), new ArrayList<Object>());

				headerCount++;
			}
		} else {
			String tempColumnName = "Column-";

			while (headerCount < sheet.getRow(firstRowNumber)
					.getLastCellNum()) {

				this.recordsTable.put(tempColumnName + headerCount, new ArrayList<Object>());

				headerCount++;
			}
			tempColumnName = null;
		}

		System.out.println("Map in datasheet :- " + this.recordsTable.entrySet());
		System.out.println("**********************************************");

		if (this.isHeaderEnabled) {
			for (int i = firstRowNumber + 1; i <= lastRowNumber; i++) {
				Row row = sheet.getRow(i);

				if (row != null) {

					int firstColumnNumber = row.getFirstCellNum();
					int lastColumnNumber = row.getLastCellNum();

					for (int j = firstColumnNumber; j < lastColumnNumber; j++) {

						this.recordsTable.get(cellToString(firstRow.getCell(j)))
								.add(cellToString(row.getCell(j)));

					}
				}
			}
		} else {
			for (int i = firstRowNumber; i <= lastRowNumber; i++) {
				Row row = sheet.getRow(i);

				if (row != null) {

					int firstColumnNumber = row.getFirstCellNum();
					int lastColumnNumber = row.getLastCellNum();
					String tempColName = "Column-";

					for (int j = firstColumnNumber; j < lastColumnNumber; j++) {

						this.recordsTable.get(tempColName + j)
								.add(cellToString(row.getCell(j)));

					}
				}
			}
		}

		workbook.close();
		fis.close();

		System.out.println("Printing the datasheet :- ");
		System.out.println(this.toString());
	}

	/**
	 * @return the recordsTable
	 */
	public Map<String, List<Object>> getRecordsTable() {
		return recordsTable;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param columnName
	 * @param rowIndex
	 * @return
	 */
	public String getCellValue(String columnName, int rowIndex) {

		String value = null;

		value = String.valueOf(this.recordsTable.get(columnName)
				.get(rowIndex));

		return value;

	}

	/**
	 * @param rowIndex
	 * @param columnIndex
	 * @return
	 */
	public String getCellValue(int rowIndex, int columnIndex) {

		String value = null;

		int count = 0;
		String columnHeader = null;

		for (String key : this.recordsTable.keySet()) {
			if (count == columnIndex) {
				columnHeader = key;
				break;
			}
			count++;
		}

		value = String.valueOf(this.recordsTable.get(columnHeader)
				.get(rowIndex));

		return value;

	}

	public String getCellValue(String cellReference) {
		String value = null;

		Matcher m = Pattern.compile("^([A-Z]+)([0-9]+)$")
				.matcher(cellReference);

		if (m.matches()) {
			String columnReference = m.group(1);

			int rowNumber = 0;

			if (this.isHeaderEnabled) {
				// rowNumber - 2 ; because the index in library is zero based and one row is
				// used as a header
				rowNumber = Integer.parseInt(m.group(2)) - 2;
			} else {
				// roNumber -1 ; because the index in library is zero based and there is no
				// header
				rowNumber = Integer.parseInt(m.group(2)) - 1;
			}

			int columnIndex = CellReference.convertColStringToIndex(columnReference);

			value = getCellValue(rowNumber, columnIndex);

		}

		return value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DataSheet [recordsTable=" + recordsTable + "]";
	}

	private static String cellToString(Cell cell) {
		if (null != cell) {
			switch (cell.getCellTypeEnum()) {
			case BOOLEAN:
				return String.valueOf(cell.getBooleanCellValue())
						.trim();

			case STRING:
				return cell.getStringCellValue()
						.trim();

			case NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					if (cell.getDateCellValue()
							.toString() == "") {
						return "";
					} else {
						return cell.toString() + "";
					}
				} else {
					Double doubleValue = cell.getNumericCellValue();
					DecimalFormat format = new DecimalFormat("#.##");
					format.setDecimalSeparatorAlwaysShown(false);
					return new String(format.format(doubleValue)
							.toString()
							.trim());
				}
			default:
				return "";
			}
		} else {
			return "";
		}
	}

}
