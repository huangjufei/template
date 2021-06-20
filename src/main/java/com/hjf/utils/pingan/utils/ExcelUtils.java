package com.hjf.utils.pingan.utils;

import com.hjf.utils.date.DateUtils;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ExcelUtils {

	/**
	 * 根据文件流获取excel的sheet
	 */
	public List<Sheet> getSheetByInputStream(InputStream input) {
		List<Sheet> listSheet = new ArrayList<>();
		Workbook importWorkbook = null;
		try {
			importWorkbook = WorkbookFactory.create(input);
			if (importWorkbook == null) {
				Logger.error(this, "=====Exception==== :" + "Excel解析错误");
			} else {
				int sheetnumbers = importWorkbook.getNumberOfSheets();

				for (int i = 0; i < sheetnumbers; i++) {
					listSheet.add(importWorkbook.getSheetAt(i));
				}
			}
		} catch (Exception e) {
			Logger.error(this, "=====IOException==== :" + "文件格式错误", e);
		}

		return listSheet;
	}

	/**
	 * 根据文件流获取excel的sheet
	 *
	 * @param
	 * @param
	 */
	public List<Sheet> getSheetByFileName(String filePath) {
		List<Sheet> listSheet = new ArrayList<>();
		Workbook importWorkbook = null;
		try {
			File inputFile = new File(filePath);
			importWorkbook = WorkbookFactory.create(inputFile);
			if (importWorkbook == null) {
				Logger.error(this, "=====Exception==== :" + "Excel解析错误");
			} else {
				int sheetnumbers = importWorkbook.getNumberOfSheets();

				for (int i = 0; i < sheetnumbers; i++) {
					listSheet.add(importWorkbook.getSheetAt(i));
				}
			}
		} catch (Exception e) {
			Logger.error(this, "=====IOException==== :" + "文件格式错误", e);
		}

		return listSheet;
	}

	/**
	 * 将单元格的数据转成String
	 *
	 */
	public String convertCellAsString(Cell cell) {
		Object result = getCellValue(cell);
		return result == null ? null : result.toString();
	}

	/**
	 * 获取cell的值
	 *
	 */
	public Object getCellValue(Cell cell) {
		if (cell == null) {
			return null;
		} else {
			int cellType = cell.getCellType();
			switch (cellType) {
			case Cell.CELL_TYPE_BLANK:// 3是null空
				return null;
			case Cell.CELL_TYPE_BOOLEAN:
				return Boolean.valueOf(cell.getBooleanCellValue());
			case Cell.CELL_TYPE_ERROR:
				return cell.getErrorCellValue();
			case Cell.CELL_TYPE_FORMULA:
				return cell.getCellFormula();
			case Cell.CELL_TYPE_NUMERIC:
				return cellTypeNumberFormat(cell);
			default:
				return cell.getStringCellValue();
			}
		}
	}

	private Object cellTypeNumberFormat(Cell cell) {
		if (DateUtil.isCellDateFormatted(cell)) {
			Date date = cell.getDateCellValue();
			return DateUtils.format(DateUtils.DATE_FORMAT_DEFAULT, date);
		} else {
			return cell.getNumericCellValue();
		}
	}

	/**
	 * 判断是否是double类型
	 *
	 */
	public boolean isDouble(Object obj) {
		return obj instanceof Double;
	}

	/**
	 * 判断是否是date类型
	 *
	 */
	public boolean isDate(Object obj) {
		return obj instanceof Date;
	}

	/**
	 * 正则日期
	 *
	 * @param obj
	 * @param obj
	 */
	public boolean isDateRex(Object obj) {
		String regStr = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][12345679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))";
		Pattern pDate = Pattern.compile(regStr);
		if (obj != null) {
			Matcher matcher = pDate.matcher(obj.toString());
			return matcher.matches();
		}
		return false;

	}

	/**
	 * 正则表达式验证以数字开头，以字母结尾的字符串
	 *
	 */
	public boolean isStartNumEndChar(String str) {
		Pattern pNumChar = Pattern.compile("[0-9a-zA-Z]*");
		Pattern pNum = Pattern.compile("[0-9]*");
		Pattern pChar = Pattern.compile("[a-zA-Z]*");
		if (str != null) {
			if (str.length() >= 2) {
				if ((pNum.matcher(str.substring(0, 1)).matches())
						&& (pChar.matcher(str.substring(str.length() - 2, str.length() - 1)).matches())
						&& (pNumChar.matcher(str).matches())) {
					return true;
				}
			} else {
				return false;
			}
		}
		return false;
	}

	/**
	 * 正则表达式验证以文本开头，以字母结尾的字符串
	 *
	 */
	public boolean isStartCharEndNum(String str) {
		Pattern pNumChar = Pattern.compile("[0-9a-zA-Z]*");
		Pattern pNum = Pattern.compile("[0-9]*");
		Pattern pChar = Pattern.compile("[a-zA-Z]*");
		if (str != null) {
			if (str.length() >= 2) {
				if ((pChar.matcher(str.substring(0, 1)).matches())
						&& (pNum.matcher(str.substring(str.length() - 2, str.length() - 1)).matches())
						&& (pNumChar.matcher(str).matches())) {
					return true;
				}
			} else {
				return false;
			}
		}
		return false;
	}

	/**
	 * 是否是百分比
	 *
	 */
	public boolean isPerCent(String str) {
		if (str != null && str.length() > 1 && str.endsWith("%")) {
			Double percent = Double.parseDouble(str.substring(0, str.length() - 2));
			if (percent >= 0 && percent <= 100) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 获取json大字段
	 *
	 * @param sheet
	 *            当前excel的sheet， startRow开始行 ，excel默认从第0行开始； endRow 结束行
	 *            excel默认最后行是length-1； kRowNum k对应的行号；kCellLength cell 的长度
	 */

	public String getJsonString(Sheet sheet, int startRow, int endRow, int kRowNum, int kCellLength) {
		boolean isNotFirstRow = false;
		StringBuilder jsonSb = new StringBuilder();
		Row kRow = sheet.getRow(kRowNum);
		String k1 = this.convertCellAsString(kRow.getCell(0));
		String k2 = this.convertCellAsString(kRow.getCell(1));
		String k3 = this.convertCellAsString(kRow.getCell(2));
		String v1 = this.convertCellAsString(kRow.getCell(kCellLength - 2));
		String v2 = this.convertCellAsString(kRow.getCell(kCellLength - 1));
		for (int i = startRow; i <= endRow; i++) {
			Row row = sheet.getRow(i);
			if (row != null) {
				if (row.getLastCellNum() == 0) {
					continue;
				}
				String ex1 = this.convertCellAsString(row.getCell(0));// 待转换成code
				String ex2 = this.convertCellAsString(row.getCell(1));// 待转换成code
				String ex3 = this.convertCellAsString(row.getCell(2));// 待转换成code
				Object ex4 = this.convertCellAsString(row.getCell(3));
				Object ex5 = this.convertCellAsString(row.getCell(4));
				if (isNotFirstRow) {
					jsonSb.append(",");
				}
				isNotFirstRow = true;
				if (ex1 != null) {
					jsonSb.append("{").append(k1).append(":").append(ex1).append(",");
				} else if (ex2 != null) {
					jsonSb.append("{").append(k2).append(":").append(ex2).append(",");
				} else if (ex3 != null) {
					jsonSb.append("{").append(k3).append(":").append(ex3).append(",");
				}
				jsonSb.append(v1).append(":").append(ex4);
				jsonSb.append(",").append(v2).append(":").append(ex5).append("}");
			}
		}
		return jsonSb.toString();
	}

}
