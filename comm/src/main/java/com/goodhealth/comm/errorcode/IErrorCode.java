package com.goodhealth.comm.errorcode;

/**
 * Extends your error codes in your App by implements this Interface.
 */
public interface IErrorCode {

    public String getErrCode();

    public String getErrMessage();

    public boolean isRetriable();
}
