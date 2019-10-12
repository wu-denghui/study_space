package com.goodhealth.comm.util.token;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.gen.RSAKeyGenerator;
import com.goodhealth.comm.exception.BaseException;
import com.goodhealth.comm.errorcode.BasicErrorCode;
import net.minidev.json.JSONObject;
import com.goodhealth.comm.util.StringUtil;
import com.goodhealth.comm.util.encrypt.DESUtils;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * TODO JWT签名使用RS256的token工具类
 */
public class RS256TokenUtils {

    private static final long VALIDATE_TIME = 60*1000*15;

    private static final String ISS="MR_WDH";

    /**
     * 这个方法采取的是RS256 非对称加密算法
     * { "iss": "Online JWT Builder",
     *   "iat": 1416797419,
     *   "exp": 1448333419,
     *   "aud": "www.example.com",
     *   "sub": "jrocket@example.com",
     *   "GivenName": "Johnny",
     *   "Surname": "Rocket",
     *   "Email": "jrocket@example.com",
     *   "Role": [ "Manager", "Project Administrator" ]
     * }
     * iss: 该JWT的签发者，是否使用是可选的；
     * sub: 该JWT所面向的用户，是否使用是可选的；
     * aud: 接收该JWT的一方，是否使用是可选的；
     * exp(expires): 什么时候过期，这里是一个Unix时间戳，是否使用是可选的；
     * iat(issued at): 在什么时候签发的(UNIX时间)，是否使用是可选的；
     * 其他还有：
     * nbf (Not Before)：如果当前时间在nbf里的时间之前，则Token不被接受；一般都会留一些余地，比如几分钟；，是否使用是可选的；
     */
    /**
     * TODO 获取token的入口
     * @param uid
     * @param userName
     * @param rsaJWK
     * @return
     */
    public static String  getTokenRS256(Integer uid, String userName, RSAKey rsaJWK) {
        String token = null;
        //获取生成token
        Map<String, Object> map = new HashMap<>();
        //建立载荷，这些数据根据业务，自己定义。
        map.put("uid", uid);
        map.put("username", userName);
        //生成时间
        map.put("iat", System.currentTimeMillis());
        //过期时间
        map.put("exp", System.currentTimeMillis()+VALIDATE_TIME);
        //JWT的签发者
        map.put("iss", ISS);
        try {
             token = RS256TokenUtils.creatTokenRS256(map,rsaJWK);
        } catch (JOSEException e) {
            e.printStackTrace();
            throw new BaseException(BasicErrorCode.TOKEN_CREATE_FAILURE);
        }
        if (StringUtil.isNotEmpty(token)){
            token = DESUtils.encode(token);
        }
        return token;
    }

    /**
     * inner 生成token
     * @param payloadMap
     * @param rsaJWK
     * @return
     * @throws JOSEException
     */
    public static String creatTokenRS256(Map<String,Object> payloadMap,RSAKey rsaJWK) throws JOSEException {
        //私钥生成签名
        JWSSigner signer = new RSASSASigner(rsaJWK);
        JWSObject jwsObject = new JWSObject(
                new JWSHeader.Builder(JWSAlgorithm.RS256).keyID(rsaJWK.getKeyID()).build(),
                new Payload(new JSONObject(payloadMap))
        );
        //进行加密
        jwsObject.sign(signer);
        String token= jwsObject.serialize();
        return token;
    }

    /**
     * TODO  解析token
     * @param token
     * @param rsaJWK
     */
    public static JSONObject analysisToken(String token, RSAKey rsaJWK) {
        if (StringUtil.isEmpty(token) || Objects.isNull(rsaJWK)){
            throw new BaseException(BasicErrorCode.PARAM_ERROR);
        }
        JSONObject jsonObject = null;
        try {
                Map<String, Object> validMap = RS256TokenUtils.validRS256(token,rsaJWK);
                Integer tokenStatus = (Integer) validMap.get("tokenStatus");
                if (tokenStatus == 0) {
                    jsonObject = (JSONObject) validMap.get("payLoad");
                } else if (tokenStatus == 2) {
                    throw new BaseException(BasicErrorCode.TOKEN_BE_OVERDUE);
                }
        } catch (ParseException e) {
            e.printStackTrace();
            throw new BaseException(BasicErrorCode.TOKEN_ANALYSIS_FAILURE);
        } catch (JOSEException e) {
            e.printStackTrace();
            throw new BaseException(BasicErrorCode.TOKEN_ANALYSIS_FAILURE);
        }
        return jsonObject;
    }

    /**
     * inner 校验token
     * @param token
     * @param rsaJWK
     * @return
     * @throws ParseException
     * @throws JOSEException
     */
    public static Map<String,Object> validRS256(String token,RSAKey rsaJWK) throws ParseException, JOSEException {
        if (StringUtil.isEmpty(token)){
            throw new BaseException(BasicErrorCode.PARAM_ERROR);
        }
        token = DESUtils.decode(token);
        //获取到公钥 公钥解析签名
        RSAKey rsaKey = rsaJWK.toPublicJWK();
        JWSObject jwsObject = JWSObject.parse(token);
        JWSVerifier jwsVerifier = new RSASSAVerifier(rsaKey);
        //验证数据
        return verify(jwsObject, jwsVerifier);
    }

    /**
     * inner 验证token信息
     * @param jwsObject
     * @param jwsVerifier
     * @return
     * @throws JOSEException
     */
    private static Map<String,Object> verify(JWSObject jwsObject,JWSVerifier jwsVerifier) throws JOSEException {
        Map<String, Object> resultMap = new HashMap<>();
        // 获取到载荷
        Payload payload=jwsObject.getPayload();
        // 判断token
        if (jwsObject.verify(jwsVerifier)) {
            resultMap.put("tokenStatus", new Integer(0));
            // 载荷的数据解析成json对象。
            JSONObject jsonObject = payload.toJSONObject();
            resultMap.put("payLoad", jsonObject);
            // 判断token是否过期
            if (jsonObject.containsKey("exp")) {
                Long expTime = Long.valueOf(jsonObject.get("exp").toString());
                Long nowTime = System.currentTimeMillis();
                // 判断是否过期
                if (nowTime > expTime) {
                    // 已经过期
                    resultMap.clear();
                    resultMap.put("tokenStatus", new Integer(2));
                }
            }
        }else {
            resultMap.put("tokenStatus", new Integer(1));
        }
        return resultMap;
    }

    /**
     * 创建加密key
     */
    public static RSAKey getKey() throws JOSEException {
        RSAKeyGenerator rsaKeyGenerator = new RSAKeyGenerator(2048);
        RSAKey rsaJWK = rsaKeyGenerator.generate();
        return rsaJWK;
    }




    public  static void main(String[] args) throws Exception{
        String username = "商大吴彦祖";
        Integer uid = 152;
        String  errToken ="      ";
        RSAKey key = RS256TokenUtils.getKey();
        String token = RS256TokenUtils.getTokenRS256(uid, username, key);
        TimeUnit.SECONDS.sleep(2);
        JSONObject object = RS256TokenUtils.analysisToken(token,key);
        System.out.println(object.toJSONString());

    }
}
