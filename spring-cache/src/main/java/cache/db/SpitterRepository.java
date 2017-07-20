package cache.db;

import cache.bean.Spitter;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;


/**
 * Repository interface with operations for {@link Spitter} persistence.
 * @author habuma
 */
public interface SpitterRepository {

  long count();

  @CachePut(value="spitterCache", key="#result.id")
  Spitter save(Spitter spitter);

  @Cacheable(value="spitterCache")
  Spitter findOne(long id);

  Spitter findByUsername(String username);

  List<Spitter> findAll();

}
