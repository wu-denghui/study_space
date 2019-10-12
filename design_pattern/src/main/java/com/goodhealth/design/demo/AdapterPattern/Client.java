/**
 * 
 */
package com.goodhealth.design.demo.AdapterPattern;

/**
 * @author 24663
 * @date 2018年10月27日
 * @Description
 */
public class Client {
	/**
	 * @param args
	 * @Description  我手中有个usb插头的设备，但是主机上只有ps2插头的插口，怎么办呢？
	 * 弄个转换器，将usb插头转换成为ps2插头就可以使用了。
	 */
	public static void main(String[] args) {
		
		Adapter adapter=new Adapter();
		adapter.connect();
	}

}
