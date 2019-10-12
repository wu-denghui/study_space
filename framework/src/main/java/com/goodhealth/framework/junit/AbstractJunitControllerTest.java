package com.goodhealth.framework.junit;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.goodhealth.framework.entity.user.BaseUser;
import com.goodhealth.framework.entity.user.UserContextEntity;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.goodhealth.framework.session.SessionManager;
import com.goodhealth.comm.util.StringUtil;
import com.goodhealth.comm.util.encrypt.MD5Util;
import javax.servlet.http.HttpServletRequest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * controller单元测试基类
 *
 * @author yadongcui
 * @date 2019-07-03 15:02
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public abstract class AbstractJunitControllerTest  {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * post请求
     */
    private static final String POST = "post";

    /**
     * get请求
     */
    private static final String GET = "get";

    /**
     * 测试账号id
     */
    private static final String TEST_USER_ID = "test1024";

    /**
     * 测试账号用户名
     */
    private static final String TEST_USER_USERNAME = "test1024";

    /**
     * 测试账号密码
     */
    private static final String TEST_USER_PASWD = "test1024";

    @Autowired
    protected WebApplicationContext context;

    protected MockMvc mvc;

    @Before
    public void setUp() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }


    /**
     * get测试请求(未登录)
     *
     * @param path
     * @param param
     */
    public String getTestNotLogin(String path, String param) {
        return accept(path, param, GET, null);
    }

    /**
     * get测试请求(未登录)
     *
     * @param path
     * @param param
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getTestNotLogin(String path, String param, Class<T> clazz) {
        return JSONObject.parseObject(this.getTestNotLogin(path, param), clazz);
    }

    /**
     * get测试请求(未登录)，针对有泛型的内部成员
     *
     * @param path
     * @param param
     * @param typeReference
     * @param <T>
     * @return
     */
    public <T> T getTestNotLogin(String path, String param, TypeReference<T> typeReference) {
        return JSONObject.parseObject(this.getTestNotLogin(path, param), typeReference);
    }


    /**
     * get测试请求(已登录)
     *
     * @param path
     * @param param
     */
    public String getTestAreadlyLogin(String path, String param) {
        // 登录
        String ecoToken = login();
        return accept(path, param, GET, ecoToken);

    }


    /**
     * get测试请求(已登录)，针对有泛型的内部成员
     *
     * @param path
     * @param param
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getTestAreadlyLogin(String path, String param, Class<T> clazz) {
        return JSONObject.parseObject(this.getTestAreadlyLogin(path, param), clazz);
    }


    /**
     * get测试请求(已登录)，针对有泛型的内部成员
     *
     * @param path
     * @param param
     * @param typeReference
     * @param <T>
     * @return
     */
    public <T> T getTestAreadlyLogin(String path, String param, TypeReference<T> typeReference) {
        return JSONObject.parseObject(this.getTestAreadlyLogin(path, param), typeReference);
    }

    /**
     * post测试请求(未登录)
     *
     * @param path
     * @param param
     */
    public String postTestNotLogin(String path, String param) {
        return accept(path, param, POST, null);
    }

    /**
     * post测试请求(未登录)
     *
     * @param path
     * @param param
     * @return
     */
    public <T> T postTestNotLogin(String path, String param, Class<T> clazz) {
        return JSONObject.parseObject(this.postTestNotLogin(path, param), clazz);
    }


    /**
     * post测试请求(未登录)，针对有泛型的内部成员
     *
     * @param path
     * @param param
     * @param typeReference
     * @return
     */
    public <T> T postTestNotLogin(String path, String param, TypeReference<T> typeReference) {
        return JSONObject.parseObject(this.postTestNotLogin(path, param), typeReference);
    }

    /**
     * post测试请求(已登录)
     *
     * @param path
     * @param param
     */
    public String postTestAreadlyLogin(String path, String param) {
        // 登录
        String ecoToken = login();
        return this.accept(path, param, POST, ecoToken);
    }

    /**
     * post测试请求(已登录)
     *
     * @param path
     * @param param
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T postTestAreadlyLogin(String path, String param, Class<T> clazz) {
        return JSONObject.parseObject(this.postTestAreadlyLogin(path, param), clazz);
    }

    /**
     * post测试请求(已登录)，针对有泛型的内部成员
     *
     * @param path
     * @param param
     * @param typeReference
     * @param <T>
     * @return
     */
    public <T> T postTestAreadlyLogin(String path, String param, TypeReference<T> typeReference) {
        return JSONObject.parseObject(this.postTestAreadlyLogin(path, param), typeReference);
    }

    /**
     * rest接口请求
     *
     * @param path   接口地址
     * @param param  参数
     * @param method 接口类型（post/get）
     */
    String accept(String path, String param, String method, String ecoToken) {
        MockHttpServletRequestBuilder request = null;
        switch (method) {
            case POST:
                request = post(path);
                break;
            case GET:
                request = get(path);
                break;
            default:
                logger.error("不支持的rest接口单元测试method");
                return null;
        }
        request.contentType(MediaType.APPLICATION_JSON_UTF8);
        request.content(JSONObject.toJSONString(param));
        request.accept(MediaType.APPLICATION_JSON);
        if (StringUtil.isNotBlank(ecoToken)) {
            request.header("token", ecoToken);
        }
        try {
            MvcResult mvcResult = mvc.perform(request)
                    //输出信息
                    .andDo(print())
                    // 状态码是否相等
                    .andExpect(status().isOk())
                    .andExpect(content().contentType("application/json; charset=utf-8"))
                    .andReturn();
            return mvcResult.getResponse().getContentAsString();
        } catch (Exception e) {
            logger.error("接口请求失败，{}", e.getMessage(),e);
        }
        return null;
    }

    /**
     * 模拟一个登录 在ecosession中填充用户信息
     * @return 本次登录返回的token
     */
    private String login() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        // 用户登录信息
        UserContextEntity userContextEntity = SessionManager.getCurrentUserContext(request, null);
        // 未登录
        if ((userContextEntity == null || StringUtil.isBlank(userContextEntity.getId()))
                && SessionManager.initJunitEcoSession(request)) {
            BaseUser baseUser = new BaseUser();
            baseUser.setId(TEST_USER_ID);
            baseUser.setUserName(TEST_USER_USERNAME);
            baseUser.setPassword(MD5Util.MD5_16(TEST_USER_PASWD,"UTF-8"));
            baseUser.setUserType(1);
            // 保存登录信息
            SessionManager.saveCurrentUserContextSession(baseUser, -1, request);
        }
        return SessionManager.getSession(request).getToken();
    }

    /**
     * request
     *
     * @return request
     */
    protected HttpServletRequest getHttpServletRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }
}
