package com.goodhealth.framework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory){
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<String,String>();
        redisTemplate.setConnectionFactory(factory);
        // key序列化方式;（不然会出现乱码;）,但是如果方法上有Long等非String类型的话，会报类型转换错误；
        // 所以在没有自己定义key生成策略的时候，以下这个代码建议不要这么写，可以不配置或者自己实现ObjectRedisSerializer
        // 或者JdkSerializationRedisSerializer序列化方式;
        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
        // Long类型不可以会出现异常信息;
        redisTemplate.setKeySerializer(redisSerializer);
        redisTemplate.setHashKeySerializer(redisSerializer);
        return redisTemplate;
    }


/*------------------------------------原始配置方式-----------------------------------------------------------*/
//    /*** 1.创建 JedisPoolConfig 对象。在该对象中完成一些链接池配置 **/
//    @Bean
//    public JedisPoolConfig jedisPoolConfig() {
//        JedisPoolConfig config = new JedisPoolConfig();
//        //最大空闲数
//        config.setMaxIdle(10);
//        // 最小空闲数
//        config.setMinIdle(5);
//        // 最大链接数
//        config.setMaxTotal(20);
//        return config;
//    }
//
//    /*** 2.创建 JedisConnectionFactory：配置 redis 链接信息 */
//    @Bean
//    public JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig config){
//        JedisConnectionFactory factory = new JedisConnectionFactory();
//        // 关联链接池的配置对象
//        factory.setPoolConfig(config);
//        // 配置链接 Redis 的信息
//        // 主机地址
//        factory.setHostName("192.168.70.128");
//        // 端口
//        factory.setPort(6379);
//        return factory;
//    }
//
//    /** 3.创建 RedisTemplate:用于执行 Redis 操作的方法 */
//   @Bean
//    public RedisTemplate<String,Object> redisTemplate(JedisConnectionFactory factory){
//        RedisTemplate<String, Object> template = new RedisTemplate<>();
//        //关联
//        template.setConnectionFactory(factory);
//        // 为 key 设置序列化器
//        template.setKeySerializer(new StringRedisSerializer());
//        // 为 value 设置序列化器
//        template.setValueSerializer(new StringRedisSerializer());
//        return template;
//    }*/

}
