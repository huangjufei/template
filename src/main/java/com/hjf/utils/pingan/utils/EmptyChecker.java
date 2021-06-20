package com.hjf.utils.pingan.utils;

import java.util.Collection;
import java.util.Map;

public class EmptyChecker {

	private EmptyChecker() {
	}

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

	public static boolean notEmpty(Object obj) {
		return !isEmpty(obj);
	}

	public static boolean isEmpty(Object[] array) {
		if (array == null || array.length == 0) {
			return true;
		}
		return false;
	}

}
