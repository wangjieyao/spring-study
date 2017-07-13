import cache.bean.Spitter;
import cache.bean.Spittle;
import cache.config.CacheConfig;
import cache.config.RootConfig;
import cache.db.SpitterRepository;
import cache.db.SpittleRepository;
import cache.db.jdbc.JdbcSpittleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

/**
 * TODO ADD DESCRIPTION
 *
 * @author wangjieyao
 * @Date 2017/7/10 20:36
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= RootConfig.class)
public class TestCache {

    @Autowired
    private SpittleRepository repository;

    @Autowired
    private SpitterRepository spitterRepository;

    @Test
    @Transactional
    public void testSave(){
        Spitter spitter = spitterRepository.findOne(1l);
        Spittle spittle = new Spittle(1l,spitter,"message",new Date(System.currentTimeMillis()));
        repository.save(spittle);
    }
    @Test
    public void testFindOne(){
        Spittle spittle = repository.findOne(1);
        System.out.println(spittle);
    }

}
