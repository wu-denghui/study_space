package com.goodhealth.comm.util.token;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.goodhealth.comm.constant.GlobalConstants;
import com.goodhealth.comm.constant.GlobalEnum;
import com.goodhealth.comm.exception.BaseException;
import com.goodhealth.comm.errorcode.BasicErrorCode;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;
import org.springframework.util.Base64Utils;
import com.goodhealth.comm.util.StringUtil;
import com.goodhealth.comm.util.encrypt.RSAUtil;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

/*
 * @ClassName HS256TokenUtils
 * @Author WuDengHui
 * @Description  TODO JWT签名使用HS256对称算法的Token工具类
 * @Date 2019/4/118:52
 **/
@Slf4j
public class HS256TokenUtils {



    private static final Map<String, Object> keyMap = RSAUtil.genKeyPair();

    /**
     * TODO 刷新Token
     * @param refreshToken
     * @return
     */
    public static String refreshToken(String refreshToken){
        Integer uid = null;
        String username = null;
        try {
            com.alibaba.fastjson.JSONObject object= com.alibaba.fastjson.JSONObject.parseObject(analysisToken(refreshToken));
            uid = (Integer) object.get("uid");
            username = (String)object.get("username");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  getTokenHS256(uid, username, GlobalEnum.ValidTimeEnum.GENERAL.getCode());
    }

    /**
     * TODO 获取token的入口
     * @param uid，username，validTime
     * @return
     */
    public static String getTokenHS256(Integer uid, String username,Long validTime) {
        Map<String, Object> map = new HashMap<>();
        /** 建立载荷，这些数据根据业务，自己定义。*/
        map.put("uid", uid);
        map.put("username", username);
        // 签发者
        map.put("iss", GlobalConstants.ISS);
        // 生成时间
        map.put("sta", System.currentTimeMillis());
        // 过期时间
        map.put("exp", System.currentTimeMillis()+validTime);
        String token = null;
        try {
            token = creatTokenHS256(map);
        } catch (JOSEException e) {
            e.printStackTrace();
            throw new BaseException(BasicErrorCode.TOKEN_CREATE_FAILURE);
        }
        if (StringUtil.isNotEmpty(token)){
            try {
                token = Base64Utils.encodeToString(RSAUtil.encryptByPrivateKey(token.getBytes(), RSAUtil.getPrivateKey(keyMap)));
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        return token;
    }

    /**
     * TODO 解析Token
     * @param token
     */
    public static String analysisToken(String token) throws  Exception{
        if (StringUtil.isEmpty(token)){
            throw new BaseException(BasicErrorCode.PARAM_ERROR);
        }
        JSONObject payLoad =null;
        try {
            Map<String, Object> validMap = validHS256(token);
            Integer tokenStatus = (Integer) validMap.get("tokenStatus");
            if (tokenStatus == 0) {
                payLoad = (JSONObject) validMap.get("payLoad");
                return payLoad.toJSONString();
            } else if (tokenStatus == 2) {
                return  GlobalEnum.StatusEnum.OVER_TIME.getName();
            }
        } catch (ParseException e) {
            throw new BaseException(BasicErrorCode.TOKEN_ANALYSIS_FAILURE);
        } catch (JOSEException e) {
            throw new BaseException(BasicErrorCode.TOKEN_ANALYSIS_FAILURE);
        }
        return GlobalEnum.StatusEnum.INVALID.getName();
    }

    /**
     * inner 生成一个token
     * @param payloadMap
     * @return
     * @throws JOSEException
     */
    private static String creatTokenHS256(Map<String,Object> payloadMap) throws JOSEException {
        /**
         * JWSHeader参数：1.加密算法法则,2.类型，3.。。。。。。。
         * 一般只需要传入加密算法法则就可以。
         * 这里则采用HS256
         * JWSAlgorithm类里面有所有的加密算法法则，直接调用。
         */
        //先建立一个头部Header
        JWSHeader jwsHeader = new JWSHeader(JWSAlgorithm.HS256);
        //建立一个载荷Payload
        Payload payload = new Payload(new JSONObject(payloadMap));
        //将头部和载荷结合在一起
        JWSObject jwsObject = new JWSObject(jwsHeader, payload);
        //建立一个密匙
        JWSSigner jwsSigner = new MACSigner(GlobalConstants.SECRET);
        //签名
        jwsObject.sign(jwsSigner);
        //生成token
        return jwsObject.serialize();
    }

    /**
     * inner  HS256解析token
     * @param token
     * @return
     * @throws Exception
     */
    public static Map<String,Object> validHS256(String token) throws Exception {
        if (StringUtil.isEmpty(token)){
            throw new BaseException(BasicErrorCode.PARAM_ERROR);
        }
        token = new String(RSAUtil.decryptByPublicKey(Base64Utils.decodeFromString(token), RSAUtil.getPublicKey(keyMap)));
        // 解析token
        JWSObject jwsObject = JWSObject.parse(token);
        // 建立一个解锁密匙
        JWSVerifier jwsVerifier = new MACVerifier(GlobalConstants.SECRET);
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
        //获取到载荷
        Payload payload=jwsObject.getPayload();
        //判断token
        if (jwsObject.verify(jwsVerifier)) {
            resultMap.put("tokenStatus", 0);
            //载荷的数据解析成json对象。
            JSONObject jsonObject = payload.toJSONObject();
            resultMap.put("payLoad", jsonObject);
            //判断token是否过期
            if (jsonObject.containsKey("exp")) {
                Long expTime = Long.valueOf(jsonObject.get("exp").toString());
                Long nowTime = System.currentTimeMillis();
                //判断是否过期
                if (nowTime > expTime) {
                    //已经过期
                    resultMap.clear();
                    resultMap.put("tokenStatus", 2);
                }
            }
        }else {
            resultMap.put("tokenStatus", 1);
        }
        return resultMap;
    }

    public  static void main(String[] args){
        String username = "商大吴彦祖";
        Integer uid = 15;
        String token = HS256TokenUtils.getTokenHS256(uid, username, GlobalEnum.ValidTimeEnum.GENERAL.getCode());
        System.out.println(token);
        try {
            String userInfo = HS256TokenUtils.analysisToken(token);
            System.out.println(com.alibaba.fastjson.JSONObject.parseObject(userInfo).get("uid"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
