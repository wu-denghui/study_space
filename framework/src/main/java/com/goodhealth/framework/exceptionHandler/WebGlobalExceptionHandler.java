package com.goodhealth.framework.exceptionHandler;

import com.goodhealth.comm.exception.BaseException;
import com.goodhealth.comm.errorcode.BasicErrorCode;
import com.goodhealth.framework.entity.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;


@ControllerAdvice
@Slf4j
public class WebGlobalExceptionHandler {

    /**
     * @Description: 异常捕捉
     * @param: [exception]
     * @return: org.springframework.http.ResponseEntity<Response>
     */
    @ExceptionHandler(value = BaseException.class)
    public ResponseEntity<Response> handleServiceException(BaseException exception, HttpServletRequest request) {
        log.error("handleServerException->exception = [{}], url = [{}]",exception, request.getRequestURI(), exception);
        return new ResponseEntity(Response.buildFailure(exception), HttpStatus.BAD_REQUEST);
    }

    /**
     * @Description:
     * @param: [exception]
     * @return: org.springframework.http.ResponseEntity<com.cmcc.hy.comm.dataobject.Response>
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Response> handleServerException(Exception exception, HttpServletRequest request) {
        log.error("handleServerException->exception = [{}], url = [{}]",exception, request.getRequestURI(), exception);
        if (exception instanceof ConstraintViolationException) {
            return new ResponseEntity(Response.buildFailure(BasicErrorCode.PARAM_ERROR), HttpStatus.BAD_REQUEST);
        }
        if (exception instanceof IllegalArgumentException) {
            return new ResponseEntity(Response.buildFailure(BasicErrorCode.PARAM_ERROR.getErrCode(), exception.getMessage()), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(Response.buildFailure(BasicErrorCode.SYS_ERROR), HttpStatus.BAD_REQUEST);
    }

}
