package cache.config;

import javax.sql.DataSource;

import cache.db.SpitterRepository;
import cache.db.SpittleRepository;
import cache.db.jdbc.JdbcSpitterRepository;
import cache.db.jdbc.JdbcSpittleRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

@Configuration
@EnableTransactionManagement
public class DataConfig implements TransactionManagementConfigurer {

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    dataSource.setUrl("jdbc:mysql://localhost:3306/spitter1?useUnicode=true&amp;characterEncoding=utf8");
    dataSource.setUsername("root");
    dataSource.setPassword("123456");
    return dataSource;
  }
  
  @Bean
  public JdbcTemplate jdbcTemplate(DataSource dataSource) {
    return new JdbcTemplate(dataSource);
  }
  
  public PlatformTransactionManager annotationDrivenTransactionManager() {
    return new DataSourceTransactionManager(dataSource());
  }

  @Bean
  public SpitterRepository spitterRepository(JdbcTemplate jdbcTemplate) {
    return new JdbcSpitterRepository(jdbcTemplate);
  }

  @Bean
  public SpittleRepository spittleRepository(JdbcTemplate jdbcTemplate) {
    return new JdbcSpittleRepository(jdbcTemplate);
  }
}
