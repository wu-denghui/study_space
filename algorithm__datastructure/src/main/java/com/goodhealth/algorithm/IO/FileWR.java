/**
 * 
 */
package com.goodhealth.algorithm.IO;

import java.io.File;
import java.io.IOException;

/**
 * @author 24663
 * @date 2018年10月12日
 * @Description
 */
public class FileWR {
	
	public boolean createFile(String PathName) {
		// 创建一个原本不存在的文件 三种格式的文件都可以创建
		// File newFile1 = new File("E:/new.txt");
		// File newFile2 = new File("E:/new.docx");
		// File newFile3 = new File("E:/new.properties");
		File newFile = new File(PathName);
		/*
		 * 判断映射的文件是否真实存在 file.exists() true存在 false不存在 如果存在即可直接操作, 否则需要调用
		 * file.createNewFile() 创建真实文件 但是以上方式只会适用创建文件本身,不包括父文件的创建(如果父文件不存在)
		 * 所以一般需要对父文件存在与否作判断
		 */
		System.out.println(newFile.exists());
		File parent = newFile.getParentFile(); // 获取父文件
		if (!parent.exists()) {
			parent.mkdirs(); // 创建所有父文件夹
		}
		try {
			newFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return newFile.exists();
	}

}
