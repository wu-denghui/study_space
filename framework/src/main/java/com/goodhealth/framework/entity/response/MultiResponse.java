package com.goodhealth.framework.entity.response;



import com.goodhealth.comm.errorcode.IErrorCode;

import java.util.Collection;

/**
 * @Author WuDengHui
 * @Description   返回数据集合的响应返回类
 * @Date 2019/4/24 10:21
 */
public class MultiResponse<T> extends Response {

    private long total;

    private Collection<T> data;


    public static <T> MultiResponse<T> of(Collection<T> data, long total) {
        MultiResponse<T> multiResponse = new MultiResponse<T>();
        multiResponse.setSuccess(true);
        multiResponse.setData(data);
        multiResponse.setTotal(total);
        return multiResponse;
    }

    public static <T> MultiResponse<T> ofWithoutTotal(Collection<T> data) {
        return of(data,0);
    }


    public long getTotal() {
        return total;
    }


    public void setTotal(long total) {
        this.total = total;
    }


    @Override
    public Collection<T> getData() {
        return data;
    }


    public void setData(Collection<T> data) {
        this.data = data;
    }

    public static MultiResponse buildFailure(String errCode, String errMessage) {
        MultiResponse response = new MultiResponse();
        response.setSuccess(false);
        response.setErrCode(errCode);
        response.setErrMessage(errMessage);
        return response;
    }

    public static MultiResponse buildFailure(IErrorCode errorCodeI) {
        MultiResponse response = new MultiResponse();
        response.setSuccess(false);
        response.setErrCode(errorCodeI.getErrCode());
        response.setErrMessage(errorCodeI.getErrMessage());
        response.setRetriable(errorCodeI.isRetriable());
        return response;
    }

    public static MultiResponse buildFailure(Response other) {
        MultiResponse response = new MultiResponse();
        response.setSuccess(false);
        response.setErrCode(other.getErrCode());
        response.setErrMessage(other.getErrMessage());
        response.setRetriable(other.isRetriable());
        return response;
    }


    public static MultiResponse buildSuccess(){
        MultiResponse response = new MultiResponse();
        response.setSuccess(true);
        return response;
    }

}

