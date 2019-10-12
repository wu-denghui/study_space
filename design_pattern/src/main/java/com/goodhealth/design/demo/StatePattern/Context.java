/**
 * 
 */
package com.goodhealth.design.demo.StatePattern;

/**
 * @author 24663
 * @date 2018年10月27日
 * @Description
 */
public class Context {
	public  final  static AbstractState run=new  Run();
	public  final  static AbstractState stopandopen=new  StopAndOpen();
	public  final  static AbstractState stopandclose=new  StopAndClose();
	
	private AbstractState currentState;

	/**
	 * @return the currentState
	 */
	public AbstractState getCurrentState() {
		return currentState;
	}

	/**
	 * @param currentState the currentState to set
	 */
	public void setCurrentState(AbstractState currentState) {
		this.currentState = currentState;
		this.currentState.setContext(this);
	}
	
	public   void  run(){
		this.currentState.run();
	}
	public   void  stop(){
		this.currentState.stop();
	}
	public   void  open(){
		this.currentState.open();
	}
	public   void  close(){
		this.currentState.close();
	}

}
