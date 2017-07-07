package cn.wangjy.study.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * TODO ADD DESCRIPTION
 *
 * @author wangjieyao
 * @Date 2017/7/6 19:38
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=RedisConfig.class)
public class TestRedis {

    @Autowired
    private RedisTemplate<String,Product> redisTemplate;

    /*@Test
    public void testSet(){
        redisTemplate.opsForSet().add("test","value");
        redisTemplate.opsForHyperLogLog().add("hyperloglog","12");
    }*/

    @Test
    public void testProduct(){
        Product product = createDate();
        redisTemplate.opsForValue().set(product.getSku(),product);
        Product p = redisTemplate.opsForValue().get(product.getSku());
        System.out.println(p.toString());

    }

    private Product createDate(){
        Product product = new Product();
        product.setName("pen");
        product.setPrice(12f);
        product.setSku("123456");
        return product;
    }
}
