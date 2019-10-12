package com.goodhealth.comm.util.token;

import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.internal.com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.goodhealth.comm.util.UUIDUtil;
import com.goodhealth.comm.util.encrypt.MD5Util;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class JwtUtil {

    private static final String SECRET = "XX#$%()(#*!()!KL<><MQLMNQNQJQK sdfkjsdrow32234545fdf>?N<:{LWPW";

    private static final String EXP = "exp";

    private static final String PAYLOAD = "payload";

    private static final String UTF = "UTF-8";

    public static synchronized String generateTonken() {
        // tonken=服务器时间+随机数+uuid+sessionId
        String tonken = Calendar.getInstance().getTimeInMillis()
                + UUIDUtil.getUUID()
                + ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getSessionId();
        // 返回md5加密处理16进制字节
        return MD5Util.MD5_16(tonken, UTF);
    }
    /**
     * TODO 加密为token
     * @param object  被加密对象  必须有无参的构造函数
     * @param maxAge  有效期
     * @param <T>
     * @return
     */
    public static <T> String sign(T object, long maxAge) {
        try {
            final JWTSigner signer = new JWTSigner(SECRET);
            final Map<String, Object> claims = new HashMap<String, Object>();
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(object);
            claims.put(PAYLOAD, jsonString);
            claims.put(EXP, System.currentTimeMillis() + maxAge);
            return signer.sign(claims);
        } catch(Exception e) {
            return null;
        }
    }

    /**
     * TODO   解析token
     * @param jwt     jwt_token
     * @param classT  解密之后应该返回的类型
     * @param <T>
     * @return
     */
    public static<T> T unsign(String jwt, Class<T> classT) {
        final JWTVerifier verifier = new JWTVerifier(SECRET);
        try {
            final Map<String,Object> claims= verifier.verify(jwt);
            if (claims.containsKey(EXP) && claims.containsKey(PAYLOAD)) {
                long exp = (Long)claims.get(EXP);
                long currentTimeMillis = System.currentTimeMillis();
                if (exp > currentTimeMillis) {
                    String json = (String)claims.get(PAYLOAD);
                    ObjectMapper objectMapper = new ObjectMapper();
                    return objectMapper.readValue(json, classT);
                }
            }
            return null;
        } catch (Exception e) {
            log.error("unsign->jwt = [{}], classT = [{}]",jwt, classT,e);
            return null;
        }
    }

    /**
     * TODO  解析历史token
     * @param jwt
     * @param classT
     * @param <T>
     * @return
     */
    public static<T> T unsignToken(String jwt, Class<T> classT) {
        final JWTVerifier verifier = new JWTVerifier(SECRET);
        try {
            final Map<String,Object> claims= verifier.verify(jwt);
            if (claims.containsKey(PAYLOAD)) {
                String json = (String)claims.get(PAYLOAD);
                ObjectMapper objectMapper = new ObjectMapper();
                return objectMapper.readValue(json, classT);
            }
            return null;
        } catch (Exception e) {
            log.error("unsign->jwt = [{}], classT = [{}]",jwt, classT,e);
            return null;
        }
    }

/*    public static void main(String[] args) {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NTU3OTE5NTQ1NTcsInBheWxvYWQiOiJ7XCJpZFwiOjIwMCxcInVzZXJuYW1lXCI6XCLlj7bljY7nmpNcIixcInBob25lTnVtXCI6bnVsbCxcImhlYWRJbWFnZVwiOlwiXCIsXCJzb25IZWFkSW1hZ2VcIjpudWxsLFwidGVuYW50SWRcIjpudWxsLFwic2Nob29sSWRcIjoyNzQsXCJjbGFzc2VzSWRzXCI6bnVsbCxcImVkdWNhdGlvbmFsT3JnSWRcIjpudWxsLFwic29uSWRcIjpudWxsLFwic29uTmFtZVwiOm51bGwsXCJyb2xlSWRzXCI6XCIxMlwiLFwicm9sZVR5cGVcIjoxLFwibWFuYWdlck9yZ0lkXCI6bnVsbH0ifQ.HcL6gMy4fZjxEQlU7344eQAGnsaG94emAEFBkh0YLtU";
        System.out.println(token);
        token = JwtUtil.sign(new Student("张三",14),60*60);
        System.out.println(JwtUtil.unsign(token,Student.class));
        final JWTVerifier verifier = new JWTVerifier(SECRET);
        try {
            final Map<String,Object> claims= verifier.verify(token);
            if (claims.containsKey(PAYLOAD)) {
                String json = (String)claims.get(PAYLOAD);
                System.out.println(json);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

}
