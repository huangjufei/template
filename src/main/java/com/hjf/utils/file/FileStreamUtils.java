package com.hjf.utils.file;

import com.hjf.utils.pingan.utils.Logger;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;



public class FileStreamUtils {

	private FileStreamUtils() {
	}

	/**
	 * 将文件流写到本地（独占写）
	 * 
	 * @param fileName
	 * @param fileInfos
	 * @param timeout
	 * @return FileUploadResp
	 */
	public static boolean writeFile(String fileName, String filePath, InputStream inputStream, long timeout) {
		boolean result = true;
		long waiting = timeout;
		File file = new File(filePath);
		String fileFullPath = filePath + "/" + fileName;
		FileOutputStream fos = null;
		FileChannel fc = null;
		FileLock fileLock = null;
		try {
			// 首先判断文件是否存在
			if (!file.exists()) {
				Logger.info(FileUtils.class, " create the file " + filePath);
				file.mkdirs();
			}
			fos = new FileOutputStream(fileFullPath);
			fc = fos.getChannel();
			while (true) {
				fileLock = fc.tryLock(); // 获取系统文件锁
				if (fileLock != null) {
					Logger.info(FileUtils.class, " get file " + fileName + " lock.");
					break;
				} else {
					Logger.info(FileUtils.class, " wait for file " + fileName + "lock...");
					Thread.sleep(1000);
					waiting--;
				}
				if (waiting == 0) {
					// 获取锁失败，退出程序
					Logger.info(FileUtils.class, " wait for lock too long to expire, it wait " + timeout + "s.");
					result = false;
					break;
				}
			}

			// 写入文件内容
			int size = 0;
			byte[] buffer = new byte[1024];
			while ((size = inputStream.read(buffer, 0, 1024)) != -1) {
				fos.write(buffer, 0, size);
				Logger.debug(FileUtils.class, "write info " + buffer + " into file...");
			}
		} catch (Exception e) {
			Logger.warn(FileUtils.class, e.getMessage(), e);
			result = false;
		} finally {
			IOUtils.closeQuietly(fc);
			IOUtils.closeQuietly(fos);
		}
		return result;
	}

}
