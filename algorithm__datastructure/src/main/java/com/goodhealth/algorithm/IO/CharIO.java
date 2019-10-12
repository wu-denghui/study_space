/**
 * 
 */
package com.goodhealth.algorithm.IO;

import java.io.*;

/**
 * @author 24663
 * @date 2018年7月16日
 * @Description 关于字符流的练习
 */
public class CharIO {

	/**
	 * @param args
	 * @Description
	 */
	public static void main(String[] args) {
		CharIO charIODemo=new CharIO();
		//	charIODemo.writeFile("D:/new.txt");
			charIODemo.readFile("D:/new.txt");

	}
	
	public char[] readFile(String patbName){
		char[] by = new char[1024];
		char[] result = null;
		File file=new File(patbName);
		if (!file.exists()) {
			System.out.println("文件不存在，请检查路径!");
		}
		FileReader fr;
		BufferedReader  br;
		try {
			fr=new  FileReader(file);
			br=new BufferedReader(fr);
			int length;
//            最为常用的读取文本方式			
//			String string=br.readLine();
//			System.out.println(string);
		    if ((length=fr.read(by))!=-1) {
//				for (int i = 0; i < length; i++) {
//					System.out.println(by[i]);
//				}
				result=new char[length];
				for (int i = 0; i < result.length; i++) {
					if (by[i]==0) {
						break;
					}else {
						result[i]=by[i];
					}
				}
			}
			for (int i = 0; i < result.length; i++) {
				System.out.println(result[i]);
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return by;
	}

	public void writeFile(String pathName) {
		File file = new File(pathName);
		try {
			if (!file.exists()) {
				File parent = file.getParentFile();
				parent.mkdirs();
				file.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		FileWriter fw = null;
		BufferedWriter bw = null ;
		BufferedReader bwi;
		try {
			 fw = new FileWriter(file);
			 bw=new BufferedWriter(fw);
			 bwi=new BufferedReader(new InputStreamReader(System.in));
			 System.out.println("请输入写入的信息");
			 String info=bwi.readLine();
			 fw.write(info);
			 bw.write(info);
			 bw.flush();
			 
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
