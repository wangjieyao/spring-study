package cn.wangjy.study.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * TODO ADD DESCRIPTION
 *
 * @author wangjieyao
 * @Date 2017/7/6 19:26
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedisConnectionFactory redisCF(){
        JedisConnectionFactory cf = new JedisConnectionFactory();
//        cf.setHostName("127.0.0.1");
//        cf.setPort(27017);
        return cf;
    }

    /*@Bean
    public StringRedisTemplate redisTemplate(RedisConnectionFactory cf){
        StringRedisTemplate redisTemplate = new StringRedisTemplate();
        redisTemplate.setConnectionFactory(cf);
        return redisTemplate;
    }*/

    @Bean
    public RedisTemplate<String,Product> redisTemplate(RedisConnectionFactory cf){
        RedisTemplate<String,Product> redisTemplate = new RedisTemplate<String,Product>();
        redisTemplate.setConnectionFactory(cf);
        //key使用StringRedisSerializer
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //value使用Jackson2JsonRedisSerializer
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<Product>(Product.class));
        return redisTemplate;
    }
}
