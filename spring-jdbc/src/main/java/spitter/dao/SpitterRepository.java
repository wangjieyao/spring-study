package spitter.dao;

import spitter.bean.Spitter;

import java.util.List;

/**
 * TODO ADD DESCRIPTION
 *
 * @author wangjieyao
 * @Date 2017/7/4 19:00
 */
public interface SpitterRepository {

    long count();

    Spitter save(Spitter spitter);

    Spitter findOne(long id);

//    Spitter findByUsername(String username);
//
//    List<Spitter> findAll();
}
