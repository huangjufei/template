package com.hjf.utils.pingan.utils;

import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * 采用MD5加密
 * 
 * @author
 * @date
 */
public class EncryptUtil {

	private EncryptUtil() { }

	public static String getFileMD5(InputStream inputStream) {
		return getFile(inputStream, "MD5");
	}

	public static String getFileSha1(InputStream inputStream) {
		return getFile(inputStream, "SHA-1");
	}
	
	private static String getFile(InputStream inputStream, String code) {
		MessageDigest digest = null;
		InputStream in = null;
		byte[] buffer = new byte[8192];
		int len;

		try {
			digest = MessageDigest.getInstance(code);
			in = inputStream;

			while ((len = in.read(buffer)) != -1) {
				digest.update(buffer, 0, len);
			}
			BigInteger bigInt = new BigInteger(1, digest.digest());
			return bigInt.toString(16);
		} catch (Exception e) {
			Logger.error(EncryptUtil.class, e.getMessage(), e);
			return null;
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e) {
				Logger.error(EncryptUtil.class, e.getMessage(), e);
			}
		}
	}
}
