package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spitter.JdbcConfig;
import spitter.bean.Spitter;
import spitter.dao.JdbcSpitterRepository;
import spitter.dao.SpitterRepository;

/**
 * TODO ADD DESCRIPTION
 *
 * @author wangjieyao
 * @Date 2017/7/4 19:31
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= JdbcConfig.class)
public class TestSpitter {

    @Autowired
    private SpitterRepository repository;

    @Test
    public void testSaveSpitter(){
        Spitter spitter = createSpitter();
        repository.save(spitter);
    }

    @Test
    public void testCount(){
        System.out.println(repository.count());
    }

    @Test
    public void testFindOne(){
        System.out.println(repository.findOne(1l));
    }

    private Spitter createSpitter(){
        Spitter spitter = new Spitter(null,"wangjy","123456","wangjieyao","test@qq.com",false);
        return spitter;
    }

}
