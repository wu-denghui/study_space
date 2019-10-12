/**
 * 
 */
package com.goodhealth.design.demo.StatePattern;

/**
 * @author 24663
 * @date 2018年10月27日
 * @Description
 */
public class StopAndClose extends AbstractState {

	/* (non-Javadoc)
	 * @see com.goodhealth.design.demo.StatePattern.AbstractState#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("电梯运行");
		this.context.setCurrentState(context.run);

	}

	/* (non-Javadoc)
	 * @see com.goodhealth.design.demo.StatePattern.AbstractState#stop()
	 */
	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("无操作--电梯已经停止了");

	}

	/* (non-Javadoc)
	 * @see com.goodhealth.design.demo.StatePattern.AbstractState#open()
	 */
	@Override
	public void open() {
		// TODO Auto-generated method stub
		System.out.println("电梯开门");
		this.context.setCurrentState(context.stopandopen);

	}

	/* (non-Javadoc)
	 * @see com.goodhealth.design.demo.StatePattern.AbstractState#close()
	 */
	@Override
	public void close() {
		// TODO Auto-generated method stub
		System.out.println("无操作--电梯门是关的");

	}

}
