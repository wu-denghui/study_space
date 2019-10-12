/**
 * 
 */
package com.goodhealth.algorithm.IO;

import java.io.*;

/**
 * @author 24663
 * @date 2018年7月17日
 * @Description  \t 空格 ('\u0009')
 * \n 换行 ('\u000A')   \\ 反斜杠   \r 回车 ('\u000D')
 * \d 数字等价于[0-9]    \D 非数字等价于[^0-9]   \s 空白符号 [\t\n\x0B\f\r]
 * \S 非空白符号 [^\t\n\x0B\f\r]   9、\w 单独字符 [a-zA-Z_0-9]
 * \W 非单独字符 [^a-zA-Z_0-9]   \f 换页符    \e Escap
 */
public class DataIODemo {
	
	public static void main(String[] args) {
		DataIODemo dataIODemo=new DataIODemo();
		dataIODemo.writeFile("D:/noo.txt");
		dataIODemo.readFile("D:/noo.txt");
		
		
	}
	public  boolean  readFile(String pathName){
		File file = new File(pathName);
		if (!file.exists()) {
			System.out.println("文件不存在，请检查路径!");
			return false;
		}
		InputStreamReader dis = null;
		BufferedReader br = null;
		try {
		 dis=new InputStreamReader(new BufferedInputStream(new FileInputStream(file)));
		 br = new BufferedReader(new FileReader(file));
		 char[] ch = new  char[1024];
		 while (br.read(ch,0,1024)!=-1){
			System.out.println(ch);
		 }
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dis.close();
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	 
	public void writeFile(String  pathName){
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

		PrintWriter dis = null;
		try {
		 dis=new PrintWriter(new BufferedOutputStream(new FileOutputStream(file,false)));
		 // FileOutputStream是字节流 按字节写入 在Java中一个汉字两个字节 所以写入中文时会乱码 需要转化为OutputStreamWriter
//			DataOutputStream提供了将Java各种类型数据的输出方法，但是其将各种数据类型以二进制形式输出，用户无法方便的进行查看。
//			使用PrintWriter类的print()和PrintLn()方法可以轻松地实现将Java的各种数据类型转换为字符串类型输出。
			//	OutputStreamWriter oStreamWriter = new OutputStreamWriter(new FileOutputStream(f), "utf-8");
			dis.print(2);
			dis.print('d');
			dis.print(5);
            dis.print("傻逼一样");
            dis.println();
            dis.print('a');
            dis.print(10);
            dis.print(Math.random());
            dis.print(true);
            dis.print(" ");
            dis.print("北京尚学堂");
            dis.print("\n");
            dis.print(",");
            dis.print("\t");
            dis.print("!");
			dis.flush();
	        /*
	        DataOutputStream dos = null; //声明数据输出流对象
	        File f = new File("D:" + File.separator + "order.txt");//指定文件的保存路径
	        OutputStreamWriter oStreamWriter = new OutputStreamWriter(new FileOutputStream(f), "utf-8");
	        dos = new DataOutputStream(new FileOutputStream(f));//实例化数据输出流对象   
	        String names[] = {"衬衣","手套","围巾"};//商品名称
	        float prices[] = {98.3f,30.3f,50.5f};    //商品价格 
	        int nums[] = {3,2,1};    //商品数量 
	        for(int i = 0;i<names.length;i++){   
	            //循环写入   
	            dos.writeChar(names[i]);    //写入字符串
	            dos.writeChar('\t');    //加入分隔符
	            dos.writeFloat(prices[i]);  //写入小数 
	            dos.writeChar('\t'); //加入分隔符  
	            dos.writeInt(nums[i]); //写入整数 
	            dos.writeChar('\n');    //换行
	         
	            oStreamWriter.write(names[i]);
	            oStreamWriter.write('\t');
	            oStreamWriter.write(prices[i]+"");  //写入小数 
	            oStreamWriter.write('\t'); //加入分隔符
	            oStreamWriter.write(nums[i]); //写入整数  
	            oStreamWriter.write('\n');  //换行
	            }  
	        oStreamWriter.close();  //关闭输出流
             */		
			} catch (Exception e) {
			e.printStackTrace();
		}finally {
				dis.close();
		}
	}

}
