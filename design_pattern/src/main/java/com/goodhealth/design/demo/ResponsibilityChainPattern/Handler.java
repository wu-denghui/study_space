package com.goodhealth.design.demo.ResponsibilityChainPattern;

public abstract class Handler {
	public static final int DM = 1;
	public static final int GM = 2;
	public static final int BS = 3;

	private int HandlerLevel;

	private Handler nextHandler;

	public Handler() {

	}

	public Handler(int handlerLevel) {
		super();
		HandlerLevel = handlerLevel;
	}

	public abstract String echo();

	public final String HandlerMessage(Request request) {
		if (this.getHandlerLevel() == request.getRequestLevel()) {
			return this.echo();
		} else {
			if (this.nextHandler != null) {
				return this.nextHandler.HandlerMessage(request);
			} else {
				return "没人处理，请假不通过";
			}
		}
	}

	public Handler getNextHandler() {
		return nextHandler;
	}

	public void setNextHandler(Handler nextHandler) {
		this.nextHandler = nextHandler;
	}

	public int getHandlerLevel() {
		return HandlerLevel;
	}

	public void setHandlerLevel(int handlerLevel) {
		HandlerLevel = handlerLevel;
	}

}
