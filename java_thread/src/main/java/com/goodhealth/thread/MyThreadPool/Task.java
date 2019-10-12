/**
 * 
 */
package com.goodhealth.thread.MyThreadPool;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;

/**
 * @author 24663
 * @date 2018年11月18日
 * @Description
 */
public class Task {

	/**
	 * 
	 * @Description  任务的执行体
	 */
	static public void action() {
//		File landi = new File("E:\\landi.jpg");
		File landi = new File("E:\\landi.JPG");
		System.out.println(landi.exists());
		File copy = createFile("E:\\cooy.jpg");
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			fis = new FileInputStream(landi);
			bis = new BufferedInputStream(fis);
			fos = new FileOutputStream(copy);
			bos = new BufferedOutputStream(fos);
			byte[] bt = new byte[1024];
			while (bis.read(bt) != -1) {
				bos.write(bt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
				fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	static public File createFile(String path) {
		File newFile = new File(path);
		if (newFile.exists()) {
			File parent = newFile.getParentFile(); // 获取父文件
			if (!parent.exists())
				parent.mkdirs(); // 创建所有父文件夹
			try {
				newFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return newFile;
	}

}
