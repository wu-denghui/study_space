package com.goodhealth.web.http;

import com.goodhealth.framework.entity.response.Response;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Body;
/**
 * @Description
 * @Author WDH
 * @Date 2019/9/23 9:49
 **/
public interface HttpApiBaiDu {

/*
      @Autowired
      private HttpApiBaiDu  httpApiBaiDu;
      httpApiBaiDu.query()
*/

/*
    @POST("/xxx/xx")
    Response query(@BodyDemoRequest request );
*/

    @GET("/?aldtype=85#zh/en/取消")
    Object query();
}
