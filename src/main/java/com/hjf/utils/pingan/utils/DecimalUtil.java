package com.hjf.utils.pingan.utils;

import java.util.regex.Pattern;

/**
 * 
 * @author ZHAOXIAOSONG365
 *
 */
public class DecimalUtil {
	static final String DECIMALWITHCOMMA = "^[+|-]?(([1-9]\\d{0,2}[,])(\\d{3}[,])*(\\d{3}(\\.\\d{1,2})?))$";
	static final String DECIMALWITHOUTCOMMA = "^[+|-]?(0|[1-9][0-9]*)(\\.\\d*)?$";

	private DecimalUtil() {}
	// 去掉数字表达式中的逗号
	public static String deletecomma(String decimal) {
		String decimalNocomma;
		Pattern formatting = Pattern.compile(DecimalUtil.DECIMALWITHCOMMA);
		if (decimal != null && formatting.matcher(decimal.trim()).matches()) {
			decimalNocomma = decimal.replace(",", "");
			return decimalNocomma;
		}
		return decimal;
	}

	// 验证是否合法的数字格式
	public static boolean isLegalDecimal(String decimal) {
		Pattern formatting = Pattern.compile(DecimalUtil.DECIMALWITHOUTCOMMA);
		return decimal==null? false : formatting.matcher(decimal.replace(",", "").trim()).matches();
	}
}