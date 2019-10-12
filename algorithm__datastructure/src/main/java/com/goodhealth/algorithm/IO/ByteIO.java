package com.goodhealth.algorithm.IO;

import java.io.*;

public class ByteIO {

	public static void main(String[] args) {
		ByteIO fileDemo=new ByteIO();

/*		//Unix下的换行符为"\n"
		out.write("\n".getBytes());
		
		//Windows下的换行符为"\r\n"
		out.write("\r\n".getBytes()); 
		
		//推荐使用，具有良好的跨平台性
		String newLine = System.getProperty("line.separator");
		out.write(newLine.getBytes()); 
 */
		fileDemo.WriteFile("D:/book.txt", "终于hongxxx123");
	}


	/**
	 * @param pathName
	 * @param info
	 * @Description 
	 * 字节输出流的五大用法
	 * 1.FileOutputStream(file)
	 * 2.DataOutputStream(FileOutputStream(file))
	 * 3.BufferedOutputStream(FileOutputStream(file))
	 * 4.DataOutputStream(BufferedOutputStream(FileOutputStream(file)))
	 * 5.OutputStreamWriter（ FileOutputStream(file)，"utf-8");将字节输出流转化为字符输出流
	 */
	public void WriteFile(String pathName,String info){
		//String  newString=new String
		File file = new File(pathName);
		if (!file.exists()) {
			File parent = file.getParentFile(); // 获取父文件
			if (!parent.exists()){
				parent.mkdirs(); // 创建所有父文件夹
			}
			try {
				file.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
/*		FileOutputStream是字节流，将文本按字节写入文件，而一个汉字是两个字节，无法一次写入，
		就会出现乱码，解决方法是使用OutputStreamWriter将字节流转换为字符流写入，同时指定utf-8编码。*/
		OutputStreamWriter osw;
		FileOutputStream fos;
		BufferedOutputStream bos;
		DataOutputStream dos;
		try {
			/*true表示内容会追加到文件末尾；false表示重写整个文件内容。*/
			fos=new FileOutputStream(file,true);
			osw=new OutputStreamWriter(fos, "utf-8");
			bos=new BufferedOutputStream(fos);
			dos=new DataOutputStream(fos);
            // 使用FileOutputStream向文件中写入字节信息
//			FileOutputStream的主要方法
//        	void	   write(byte[] b) 将 b.length 个字节从指定 byte 数组写入此文件输出流中。
//	    	void	   write(byte[] b, int off, int len) 将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此文件输出流。
//	    	void	   write(int b)  将指定字节写入此文件输出流。
			fos.write(info.getBytes());
			//显示   终于hongxxx123
			/* 当6改为4的时候会显示乱码，应为一个汉字两个字节，字节数不够时，系统无法识别*/
			fos.write(info.getBytes(), 0,6);
			//显示 终于
			byte y='y';
			fos.write(y);
			//显示 y
			int an=117;
			//显示u ASCII中117所对应的字符
			fos.write(an);
			fos.write("\r\n".getBytes());//换行

//使用OutputStreamWriter+FileOutputStream向文件写入信息（最后需要flush缓存）
			/* OutputStreamWriter的主要方法
			     void	close() 关闭此流，但要先刷新它。
                 void	 flush()  刷新该流的缓冲。
                 String	getEncoding() 返回此流使用的字符编码的名称。
                 void	write(char[] cbuf, int off, int len) 写入字符数组的某一部分。
                 void	write(int c) 写入单个字符。
                 void	write(String str, int off, int len) 写入字符串的某一部分。
             */
			      osw.write(info.toCharArray()); //显示 终于hongxxx123
			      osw.write(info.toCharArray(), 0, 4);//显示 终于ho
			      osw.write(',');//显示 ，
			      osw.write(info,0,4);//显示 终于ho
			      osw.write('B');//显示 B
			      String  newLine=System.getProperty("line.separator");
			      osw.write(newLine);// 换行
			      osw.flush();
/*
使用DataOutputStream+FileOutputStream向文件中写入信息（DataOutputStream是用来写二进制数据的）
DataOutputStream提供了将Java各种类型数据的输出方法，但是其将各种数据类型以二进制形式输出，
用户无法方便的进行查看，用DataInputStream按写的顺序读进来才可看到原来的数据。
如果想使写入文件的数据可读，需要用到PrintWriter类.
使用PrintWriter类的print()和PrintLn()方法可以轻松地实现将Java的各种数据类型转换为字符串类型输出。	
*/
	/* void	flush()  清空此数据输出流。
		 int	size()   返回计数器 written 的当前值，即到目前为止写入此数据输出流的字节数。
		 void	write(byte[] b, int off, int len) 将指定 byte 数组中从偏移量 off 开始的 len 个字节写入基础输出流。
		 void	write(int b) 将指定字节（参数 b 的八个低位）写入基础输出流。
		 void	writeBoolean(boolean v) 将一个 boolean 值以 1-byte 值形式写入基础输出流。
		 void	writeByte(int v) 将一个 byte 值以 1-byte 值形式写出到基础输出流中。
		 void	writeBytes(String s)  将字符串按字节顺序写出到基础输出流中。
		 void	writeChar(int v)  将一个 char 值以 2-byte 值形式写入基础输出流中，先写入高字节。
		 void	writeChars(String s) 将字符串按字符顺序写入基础输出流。
		 void	writeDouble(double v) 使用 Double 类中的 doubleToLongBits 方法将 double 参数转换为一个
		  long 值，然后将该 long 值以 8-byte 值形式写入基础输出流中，先写入高字节。
		 void	writeFloat(float v)使用 Float 类中的 floatToIntBits 方法将 float 参数转换为一个 int 值，
		 然后将该 int 值以 4-byte 值形式写入基础输出流中，先写入高字节。
		 void	writeInt(int v) 将一个 int 值以 4-byte 值形式写入基础输出流中，先写入高字节。
		 void	writeLong(long v)将一个 long 值以 8-byte 值形式写入基础输出流中，先写入高字节。
		 void	writeShort(int v) 将一个 short 值以 2-byte 值形式写入基础输出流中，先写入高字节。
		 void	writeUTF(String str)以与机器无关方式使用 UTF-8 修改版编码将一个字符串写入基础输出流。
		 */
/*			      dos.writeBoolean(true);//乱码
			      dos.writeShort(2);//乱码
			      dos.writeByte('c');//乱码
			      dos.writeInt(4);//乱码
			      dos.writeLong(40);//乱码
			      dos.writeFloat(4.0f);//乱码
			      dos.writeDouble(40.0);//乱码
*/			      dos.writeUTF(info);//显示 终于hongxxx123
                   dos.writeUTF("\r\n");
			
			
//使用BufferedOutputStream+FileOutputStream向文件中写入字节信息(最后需要flush)
                   
/*		 void	flush() 刷新此缓冲的输出流。
		 void	write(byte[] b, int off, int len)将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此缓冲的输出流。
		 void	write(int b)将指定的字节写入此缓冲的输出流。
*/
			      bos.write(info.getBytes());//显示 终于hongxxx123
			      bos.write(info.getBytes(),0,6);//显示 终于
			      char a='V';
			      int aan=117;
			      bos.write(aan);//显示 u
			      bos.write(a);//显示 V
			      bos.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
//			bos.close();
		}
	}

	/**
	 *    读取文件字节
	 * @param
	 */
	public void readFile(String pathName) {
		File file = new File(pathName);
		FileInputStream fs;
		DataInputStream dis;
		BufferedInputStream bis;
		byte[] by=new byte[1024];
		try {
			fs = new FileInputStream(file);
			dis = new DataInputStream(fs);
			bis = new BufferedInputStream(fs);
			//使用FileInputStream读取文件字节信息
			fs.read(by);
			System.out.println(by[0]);
			//使用FileInputStream+DataInputStream读取文件字节信息
			dis.read(by);
			//使用FileInputStream+BufferedInputStream读取文件字节信息
			bis.read(by);
			while( bis.read(by)!=-1) {
				System.out.println(by[0]);
			}
			System.out.println(1111111);
			// 如果在读取所需字节数之前已经到达文件末尾 (end of file)，则将抛出EOFException（IOException的一种）。
			// 如果因为到达文件末尾以外的其他原因无法读取字节，则将抛出 IOException 而不是 EOFException。
			// 尤其是，在输入流已关闭的情况下，将抛出 IOException。
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (EOFException e) {
			System.out.println("读取所需字节数之前已经到达文件末尾");
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}
	public byte[] readFileReturn(String pathName) {
		File file = new File(pathName);
		FileInputStream fs;
		DataInputStream dis;
		ByteArrayOutputStream bis = null;
		byte[] by=new byte[1024];
		try {
			fs = new FileInputStream(file);
			dis = new DataInputStream(fs);
			bis = new ByteArrayOutputStream();
			//使用FileInputStream读取文件字节信息
//			fs.read(by);
//			System.out.println(by[0]);
			//使用FileInputStream+DataInputStream读取文件字节信息
//			dis.read(by);
			//使用FileInputStream+BufferedInputStream读取文件字节信息
			int length;
			  while ((length = dis.read(by)) > 0) {
		            bis.write(by, 0, length);
		        }
			// 如果在读取所需字节数之前已经到达文件末尾 (end of file)，则将抛出EOFException（IOException的一种）。
			// 如果因为到达文件末尾以外的其他原因无法读取字节，则将抛出 IOException 而不是 EOFException。
			// 尤其是，在输入流已关闭的情况下，将抛出 IOException。
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (EOFException e) {
			System.out.println("读取所需字节数之前已经到达文件末尾");
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return bis.toByteArray();

	}
	public  void  copyFile(String filePath1,String filePath2){
		File file1=new File(filePath1);
		File file2=new File(filePath2);
		FileInputStream fis;
		BufferedInputStream bis = null;
		FileOutputStream fos;
		BufferedOutputStream   bos = null;
		byte[] by=new byte[1024];
		try {
			fis=new FileInputStream(file1);
			bis=new BufferedInputStream(fis);
			fos=new  FileOutputStream(file2);
			bos=new BufferedOutputStream(fos);
			int  length;
			while( (length=bis.read(by))!=-1) {
				bos.write(by,0,length);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
