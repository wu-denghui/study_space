package com.goodhealth.comm.errorcode;


public enum BasicErrorCode implements IErrorCode {

    PARAM_ERROR("1000" , "参数校验错误" , false),
    REQUEST_PARAM_ERROR("1000" , "请求参数校验错误" , false),
    BIZ_ERROR("2000" , "业务逻辑错误" , false),
    INFRA_ERROR("3000" , "基础设施(数据库，缓存，消息等)错误" , true),
    SYS_ERROR("4000" , "未知的其它系统错误" , true),
    USERNAME_BE_USE("4001" , "用户名已被使用,请换个用户名注册", false),
    USERNAME_PASSWORD_ERROR("4002" , "账号或密码错误" , false),
    PHONE_BE_USE("4003" , "手机号已被注册，请确认您的手机号" , false),
    USER_INVALID("5000", "无效用户或登录失效", false),
    ID_INVALID("5001", "id无效", false),
    TOKEN_ANALYSIS_FAILURE("4004" , "Token解析失败" , false),
    TOKEN_CREATE_FAILURE("4005" , "Token生成失败" , false),
    TOKEN_BE_OVERDUE("4006" , "Token过期" , false),
    RSA_ERROR("4007" , "RSA错误" , false),
    ;

    private String errCode;
    private String errMessage;
    private boolean retriable;

    public static BasicErrorCode getBasicErrorCode(String errMessage){
        for (BasicErrorCode errorCode : BasicErrorCode.values()){
            if (errorCode.getErrMessage().equals(errMessage)){
                return errorCode;
            }
        }
        return null;
    }

    private BasicErrorCode(String errCode, String errMessage){
        this(errCode,errMessage,false);
    }

    private BasicErrorCode(String errCode, String errMessage, boolean retriable){
        this.errCode = errCode;
        this.errMessage = errMessage;
        this.retriable = retriable;
    }

    @Override
    public String getErrCode() {
        return errCode;
    }

    @Override
    public String getErrMessage() {
        return errMessage;
    }

    @Override
    public boolean isRetriable() {
        return retriable;
    }
}
