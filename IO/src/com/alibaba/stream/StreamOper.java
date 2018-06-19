package com.alibaba.stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class StreamOper {

	public StreamOper() {

	}

	/**
	 * @param src
	 * @param dest
	 */
	public static void copyFile(String src, String dest) {

		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			fis = new FileInputStream(src);
			fos = new FileOutputStream(dest);
			byte[] b = new byte[1024];
			int len = 0;
			while ((len = fis.read(b)) != -1) {
				fos.write(b, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * @param src
	 * @param dest
	 */
	public static void copyFileWithBuffer(String src, String dest) {

		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;

		try {
			fis = new FileInputStream(src);
			fos = new FileOutputStream(dest);
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			byte[] b = new byte[1024];
			int len = 0;
			while ((len = bis.read(b)) != -1) {
				bos.write(b, 0, len);
				bos.flush();// 每次写数据后要刷新
			}
		} catch (IOException e) {
			System.out.println("\n出现异常!!\n");
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					System.out.println("\n关闭fis出现异常!!\n");
					e.printStackTrace();
				}
			}
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					System.out.println("\n关闭bis出现异常!!\n");
					e.printStackTrace();
				}
			}
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					System.out.println("\n关闭bos出现异常!!\n");
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * @param content
	 * @param pos
	 */
	public static void insert(String fileName, String content, int pos) {
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(fileName, "rw");
			StringBuilder builder = new StringBuilder();
			String str = null;
			raf.seek(pos);
			while ((str = raf.readLine()) != null) {
				builder.append(str);
			}
			raf.seek(pos);
			raf.write(content.getBytes());
			raf.write(builder.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (raf != null) {
				try {
					raf.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
