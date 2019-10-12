package com.goodhealth.comm.exception;

import com.goodhealth.comm.errorcode.BasicErrorCode;
import com.goodhealth.comm.errorcode.IErrorCode;

public class BaseException extends RuntimeException {

    private String errCode;
    private String errMessage;
    private boolean retriable;

    public BaseException(String errMessage){
        super(errMessage, null, false, false);
        this.transErrorCodeI(BasicErrorCode.BIZ_ERROR);
    }

    public BaseException(String errCode, String errMessage){
        this.errCode = errCode;
        this.errMessage = errMessage;
    }

    public BaseException(IErrorCode errCode, String errMessage){
        super(errMessage, null, false, false);
    	this.transErrorCodeI(errCode);
    	setErrMessage(errMessage);
    }

    public BaseException(IErrorCode errCode){
        super(errCode.getErrMessage(), null, false, false);
        this.transErrorCodeI(errCode);
    }

    public BaseException(String errMessage, Throwable e) {
        super(errMessage, e, true, true);
        this.transErrorCodeI(BasicErrorCode.BIZ_ERROR);
        setErrMessage(errMessage);
    }


    public void transErrorCodeI(IErrorCode errCodeI) {
        this.errCode = errCodeI.getErrCode();
        this.errMessage = errCodeI.getErrMessage();
        this.retriable = errCodeI.isRetriable();
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }

    public boolean isRetriable() {
        return retriable;
    }

    public void setRetriable(boolean retriable) {
        this.retriable = retriable;
    }
}