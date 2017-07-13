package cache.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("cache.db")
@Import({DataConfig.class, CacheConfig.class})
public class RootConfig {

}
