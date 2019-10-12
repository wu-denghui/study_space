package com.goodhealth.framework.entity.response;


import com.goodhealth.comm.exception.BaseException;
import com.goodhealth.comm.errorcode.IErrorCode;
import com.goodhealth.framework.entity.DTO;

/**
 * @ClassName Response
 * @Author WuDengHui
 * @Description
 * @Date 2019/4/249:56
 **/
public class Response<T> extends DTO implements IErrorCode {

    private static final long serialVersionUID = 1L;

    private T data;

    private boolean success;

    private String errCode;

    private String errMessage;

    private boolean retriable;



    public static <T> Response<T> of(T data) {
        Response<T> singleResponse = new Response<T>();
        singleResponse.setSuccess(true);
        singleResponse.setData(data);
        return singleResponse;
    }


    public static Response buildFailure(String errCode, String errMessage) {
        Response response = new Response();
        response.setSuccess(false);
        response.setErrCode(errCode);
        response.setErrMessage(errMessage);
        return response;
    }

    public static Response buildFailure(IErrorCode IErrorCode) {
        Response response = new Response();
        response.setSuccess(false);
        response.setErrCode(IErrorCode.getErrCode());
        response.setErrMessage(IErrorCode.getErrMessage());
        response.setRetriable(IErrorCode.isRetriable());
        return response;
    }

    public static Response buildFailure(Response other) {
        Response response = new Response();
        response.setSuccess(false);
        response.setErrCode(other.getErrCode());
        response.setErrMessage(other.getErrMessage());
        response.setRetriable(other.isRetriable());
        return response;
    }

    public static Response buildFailure(BaseException bizException) {
        Response response = new Response();
        response.setSuccess(false);
        response.setErrCode(bizException.getErrCode());
        response.setErrMessage(bizException.getErrMessage());
        response.setRetriable(bizException.isRetriable());
        return response;
    }

    public static Response buildSuccess(){
        Response response = new Response();
        response.setSuccess(true);
        return response;
    }

    public boolean isSuccess() {
        return success;
    }


    public void setSuccess(boolean success) {
        this.success = success;
    }


    @Override
    public String getErrCode() {
        return errCode;
    }


    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }


    @Override
    public String getErrMessage() {
        return errMessage;
    }


    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }

    @Override
    public boolean isRetriable() {
        return retriable;
    }

    public void setRetriable(boolean retriable) {
        this.retriable = retriable;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}
