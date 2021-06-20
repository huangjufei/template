package com.hjf.utils.pingan.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileUtils {

	private FileUtils() {
	}

	public static String getFileType(String fileName) {
		int index = fileName.lastIndexOf('.');
		int length = fileName.length();
		String fileType;
		if (index == -1) {
			fileType = "";
		} else {
			fileType = fileName.substring(index, length);
		}
		return fileType;
	}

	/**
	 * 文件操作
	 * 从HttpServletRequest中获取文件数据流并封装成ByteArrayOutputStream对象
	 * @author     ZENGHAIYANG801
	 * @since      2017年4月7日 下午3:36:16
	 * 参数格式     request
	 * 返回值格式   ByteArrayOutputStream
	 */
	public static ByteArrayOutputStream readFileFromRequest(InputStream inputStream) {
		ByteArrayOutputStream temp = new ByteArrayOutputStream();
		try {
			int read;
			byte[] buffer = new byte[1024];

			while ((read = inputStream.read(buffer, 0, 1024)) != -1) {
				temp.write(buffer, 0, read);
			}
		} catch (IOException e) {
			Logger.error(FileUtils.class, e.getMessage(), e);
		}
		return temp;
	}
}
