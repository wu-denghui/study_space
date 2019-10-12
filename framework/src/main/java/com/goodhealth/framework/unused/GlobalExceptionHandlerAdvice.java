//package config;
//
//import com.alibaba.fastjson.JSONObject;
//import com.deppon.dpboot.framework.logging.Logger;
//import com.deppon.dpboot.framework.logging.LoggerFactory;
//import com.deppon.eco.base.constant.GlobalConstants;
//import com.deppon.eco.base.entity.response.BaseResponse;
//import com.deppon.eco.framework.mvc.exception.BusinessException;
//import com.deppon.eco.framework.util.StringUtil;
//import feign.FeignException;
//import feign.RetryableException;
//import org.springframework.stereotype.Component;
//import org.springframework.web.HttpRequestMethodNotSupportedException;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//import retrofit.RetrofitError;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * 统一异常处理
// * @author yadongcui
// * @date 2019-03-25 19:07
// *
// */
//@ControllerAdvice
//@Component
//public class GlobalExceptionHandlerAdvice {
//
//    private Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    public static Map<String, String> nsfExceptionMap = new HashMap<>();
//
//    static {
//        // nsf服务治理，限流
//        nsfExceptionMap.put("NsfRateLimiterException", "您的操作过于频繁，请稍后重试");
//
//        // nsf服务治理，降级（熔断）
//        nsfExceptionMap.put("HystrixRuntimeException", "该服务暂时不可用，请稍后重试");
//
//        // feignclient 调用服务不可用
//        nsfExceptionMap.put("ClientException", "调用服务不可用，请稍后重试");
//    }
//
//    /**
//     *
//     * 参数校验失败，异常处理
//     *
//     * @param request
//     * @param e
//     * @return
//     */
//    @ExceptionHandler(value = MethodArgumentNotValidException.class)
//    @ResponseBody
//    public BaseResponse paramExceptionHandler(HttpServletRequest request, MethodArgumentNotValidException e){
//        // 返回字段校验信息
//        return new BaseResponse(GlobalConstants.FAIL, e.getBindingResult().getFieldError().getDefaultMessage());
//    }
//
//    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
//    @ResponseBody
//    public BaseResponse paramExceptionHandler(HttpServletRequest request, HttpRequestMethodNotSupportedException e){
//        // 返回字段校验信息
//        return new BaseResponse(GlobalConstants.FAIL, e.getMessage());
//    }
//
//
//    /**
//     *
//     * Exception异常处理
//     *
//     * @param e
//     * @return
//     */
//    @ExceptionHandler(value = Exception.class)
//    @ResponseBody
//    public BaseResponse exceptionHandler(Exception e){
//        logger.error("服务端异常，Exception", e);
//        return new BaseResponse(GlobalConstants.FAIL, GlobalConstants.EXCEPTION_SERVER);
//    }
//
//
//    /**
//     * BusinessException业务异常处理
//     * @param e
//     * @return
//     */
//    @ExceptionHandler(value = BusinessException.class)
//    @ResponseBody
//    public BaseResponse bussinessExceptionHandler(BusinessException e){
//        logger.error("服务端异常，BusinessException", e);
//        return new BaseResponse(GlobalConstants.FAIL, e.getMessage(), e.getStatusCode());
//    }
//
//    /**
//     *
//     * RuntimeException异常处理
//     *
//     * @param request
//     * @param e
//     * @return
//     */
//    @ExceptionHandler(value = RuntimeException.class)
//    @ResponseBody
//    public BaseResponse runtimeExceptionHandler(HttpServletRequest request, RuntimeException e){
//        logger.error("服务端异常，RuntimeException", e);
//
//        // nsf 服务治理异常处理
//        if(nsfExceptionMap!=null){
//            String name = e.getClass().getName().substring(e.getClass().getName().lastIndexOf(".")+1);
//            if(nsfExceptionMap.containsKey(name)){
//                return new BaseResponse(GlobalConstants.FAIL, nsfExceptionMap.get(name));
//            }
//        }
//
//        return new BaseResponse(GlobalConstants.FAIL, GlobalConstants.RUNTIME_EXCEPTION_SERVER);
//    }
//
//    /**
//     * RetrofitError 接口调用失败
//     *
//     * @param request
//     * @param e
//     * @return
//     */
//    @ExceptionHandler(value = RetrofitError.class)
//    @ResponseBody
//    public BaseResponse retrofitErrorHandler(HttpServletRequest request, RetrofitError e){
//        logger.error("服务端异常，RetrofitError，接口调用失败[{}]，失败原因：{}", e.getUrl(),e.getMessage(), e);
//
//        return new BaseResponse(GlobalConstants.FAIL, e.getMessage());
//    }
//
//    @ExceptionHandler(value = FeignException.class)
//    @ResponseBody
//    public BaseResponse feignExceptionHandler(HttpServletRequest request, FeignException e){
//        logger.error("服务端异常，FeignException", e);
//        if(StringUtil.isNotBlank(e.getMessage())){
//            String errMsg = e.getMessage().substring(e.getMessage().lastIndexOf("{"));
//            if(StringUtil.isNotBlank(errMsg)){
//                return JSONObject.parseObject(errMsg, BaseResponse.class);
//            }
//        }
//        return new BaseResponse(GlobalConstants.FAIL, e.getMessage());
//    }
//
//    @ExceptionHandler(value = RetryableException.class)
//    @ResponseBody
//    public BaseResponse feignExceptionHandler(HttpServletRequest request, RetryableException e){
//        logger.error("服务端异常，RetryableException", e);
//        return new BaseResponse(GlobalConstants.FAIL, e.getMessage());
//    }
//
//
//}