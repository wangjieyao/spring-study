package cache;

//import org.springframework.cache.CacheManager;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.ehcache.EhCacheCache;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.cache.support.CompositeCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WangJieYao on 2017/7/9.
 */
@Configuration
//启用缓存
@EnableCaching
public class CacheConfig {

    /**
     * 声明缓存管理器
     * @return
     */
//    @Bean
//    public CacheManager cacheManager(){
//        return new ConcurrentMapCacheManager();
//    }

    @Bean
    public EhCacheCacheManager cacheManager(CacheManager cm){
        return new EhCacheCacheManager(cm);
    }

    @Bean
    public EhCacheManagerFactoryBean ehcache(){
        EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource("cache/ehcache.xml"));
        return ehCacheManagerFactoryBean;
    }

    /*@Bean
    public JedisConnectionFactory redisConnectionFactory(){
        JedisConnectionFactory jcf = new JedisConnectionFactory();
        jcf.afterPropertiesSet();
        return jcf;
    }

    @Bean
    public RedisTemplate<String,String> redisTemplate(RedisConnectionFactory rcf){
        RedisTemplate<String,String> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(rcf);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    *//**
     * 使用redis缓存管理器
     * @param redisTemplate
     * @return
     *//*
    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate){
        return new RedisCacheManager(redisTemplate);
    }*/

   /* *//**
     * 使用多个缓存管理器
     * @param redisTemplate
     * @return
     *//*
    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate){
        CompositeCacheManager cacheManager = new CompositeCacheManager();
        List<CacheManager> cacheManagers = new ArrayList<>();
        cacheManagers.add(new RedisCacheManager(redisTemplate));
        cacheManagers.add(new ConcurrentMapCacheManager());
        cacheManager.setCacheManagers(cacheManagers);
        return cacheManager;
    }*/
}
