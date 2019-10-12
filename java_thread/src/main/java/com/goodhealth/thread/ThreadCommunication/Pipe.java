package com.goodhealth.thread.ThreadCommunication;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Scanner;

/**
 * @author 24663
 * @date 2018年11月17日
 * @Description
 */
public class Pipe {

	public static void main(String[] args) {
		Sender ts = new Sender();
		Receive tr = new Receive(ts.reader);
		ts.start();
         while (true) {
        	 if (ts.getBoolean()) {
        		 tr.start();
				 break;
			}
		}
	}

}

class Sender extends Thread {
	private PipedWriter writer = new PipedWriter();
	public PipedReader reader = new PipedReader();
	
	 volatile boolean  boo=false;
	 
	 volatile boolean  over=true;

	public Sender() {
		try {
			writer.connect(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public  void  setOver(){
		over=false;
	}
	
	public  boolean  getBoolean(){
		
		return  boo;
	}

	@Override
	public void run() {
		Scanner in = new Scanner(System.in);
		String temp;
		try {
		while ((temp = in.nextLine()) != "exit") {
/*			while(over){
				temp = in.nextLine();*/
				writer.write(temp);
			}
			boo=true;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

class Receive extends Thread {
	
	private PipedReader reader;

	public Receive(PipedReader reader) {
		super();
		this.reader = reader;
	}

	public void run() {
			int text = 0;
			try {
				if (reader != null) {
					while ((text = reader.read()) != -1) {
						System.out.print((char) text);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}
