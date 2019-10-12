/**
 * 
 */
package com.goodhealth.design.demo.Proxy;

/**
 * @author 24663
 * @date 2018年10月21日
 * @Description
 */
public class Monitor implements Person {
	
	    private  Teacher  te=null;

	    /**
	     * @param te
	     */
	    public Monitor(Teacher te) {
	    	super();
	    	this.te = te;
	    }
	    /* (non-Javadoc)
	     * @see com.goodhealth.design.demo.Proxy.Person#receiveHomework()
	     */
	    
	@Override
	public void receiveHomework() {
		this.before();
		this.te.receiveHomework();  //实际上还是被代理类在工作
		this.after();
	}

	 public  void before(){
		 System.out.println("班长说老师要把作业收上来");
	 }
	
	 public  void after(){
		 System.out.println("作业送到老师办公室");
	 }
	

}
