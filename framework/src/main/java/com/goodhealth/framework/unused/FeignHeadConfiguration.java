//package config;
//
//import com.deppon.dpboot.framework.logging.Logger;
//import com.deppon.dpboot.framework.logging.LoggerFactory;
//import com.deppon.eco.base.constant.GlobalConstants;
//import com.deppon.eco.framework.mvc.session.EcoSession;
//import com.deppon.eco.framework.mvc.session.EcoSessionManager;
//import com.deppon.eco.framework.redis.RedisService;
//import feign.RequestInterceptor;
//import feign.RequestTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//
///**
// * feign请求头配置
// *
// * @author yadongcui
// * @date 2019-05-22 14:00
// *
// */
//@Configuration
//public class FeignHeadConfiguration implements RequestInterceptor {
//
//    private final Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    @Autowired
//    private RedisService redisService;
//
//    @Override
//    public void apply(RequestTemplate requestTemplate) {
//        // 标记是feign远程调用
//        requestTemplate.header(GlobalConstants.HEADER_FEIGIN_REMOTE_CALL, GlobalConstants.IS_Y);
//
//        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        if (attrs != null) {
//
//            HttpServletRequest request = attrs.getRequest();
//
//            EcoSession ecoSession = EcoSessionManager.getSession(request);
//
//            if(null != ecoSession){
//                requestTemplate.header(GlobalConstants.ECO_TOKEN, ecoSession.getToken());
//            }
//        }
//    }
//}
