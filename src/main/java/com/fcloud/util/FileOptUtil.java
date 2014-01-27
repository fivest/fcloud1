package com.fcloud.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileOptUtil {
	/**
	 * 检查路径是否存在
	 * 
	 * @param path
	 * @return
	 */
	public static boolean checkFilePath(String path) {
		File file = new File(path);
		return file.exists();
	}

	/**
	 * 只创建一个目录
	 * 
	 * @param path
	 * @return
	 */
	public static boolean createFilePath(String path) {
		File file = new File(path);
		if (file.exists()) {
			return false;
		}
		return file.mkdir();
	}

	/**
	 * 创建一个目录，如果父目录不存在，则创建父目录
	 * 
	 * @param path
	 * @return
	 */
	public static boolean createFilePaths(String path) {
		File file = new File(path);
		if (file.exists()) {
			return false;
		}
		return file.mkdirs();
	}

	/**
	 * 写文件操作
	 * 
	 * @param is
	 * @param path
	 * @throws Exception
	 */
	public static void createFile(InputStream is, String path) throws Exception {
		File file = new File(path);
		OutputStream out = new BufferedOutputStream(new FileOutputStream(file));
		byte[] buffer = new byte[8192];
		int bytesRead = 0;

		while ((bytesRead = is.read(buffer, 0, 8192)) != -1) {
			out.write(buffer, 0, bytesRead);
		}

		out.close();
		is.close();
	}

	public static InputStream getFile(String path) {
		InputStream is = null;

		return is;
	}

	public static void main(String[] args) {
		String path = "D://test/test";
		System.out.println(checkFilePath(path));
		System.out.println(createFilePath(path));
		System.out.println(createFilePaths(path));

	}
}
