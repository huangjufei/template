package com.hjf.utils.pingan.utils;

import java.util.Collection;
import java.util.Map;

/**
 * 判断null
 */
public class EmptyChecker {

	private EmptyChecker() {
	}

	/**
	 * 判断对象,Collection,map,字符串是否为null
	 */
	public static boolean isEmpty(Object obj) {
		if (obj == null) {
			return true;
		}
		if (obj instanceof String) {
			return ((String) obj).trim().length() == 0;
		}
		if (obj instanceof Collection) {
			return ((Collection<?>) obj).isEmpty();
		}
		if (obj instanceof Map) {
			return ((Map<?, ?>) obj).isEmpty();
		}
		return false;
	}

	/**
	 * 不为null
	 */
	public static boolean notEmpty(Object obj) {
		return !isEmpty(obj);
	}

	/**
	 * 数组对象判断null
	 */
	public static boolean isEmpty(Object[] array) {
		if (array == null || array.length == 0) {
			return true;
		}
		return false;
	}

}
