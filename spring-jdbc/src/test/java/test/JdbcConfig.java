//package test;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
//import org.springframework.transaction.PlatformTransactionManager;
//import spitter.dao.JdbcSpitterRepository;
//import spitter.dao.SpitterRepository;
//
//import javax.sql.DataSource;
//
//
//@Configuration
//@ComponentScan
//public class JdbcConfig {
//
//  @Bean
//  public DataSource dataSource() {
//    DriverManagerDataSource dataSource = new DriverManagerDataSource();
//    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//    dataSource.setUrl("jdbc:mysql://localhost:3306/spitter?useUnicode=true&amp;characterEncoding=utf8");
//    dataSource.setUsername("root");
//    dataSource.setPassword("123456");
//    return dataSource;
//  }
//
////  @Bean
////  public DataSource dataSource() {
////    return new EmbeddedDatabaseBuilder()
////      .setType(EmbeddedDatabaseType.H2)
////      .addScripts("classpath:spittr/db/jdbc/schema.sql", "classpath:spittr/db/jdbc/test-data.sql")
////      .build();
////  }
//
//  @Bean
//  public JdbcTemplate jdbcTemplate(DataSource dataSource) {
//    return new JdbcTemplate(dataSource);
//  }
//
//  @Bean
//  public SpitterRepository spitterRepository(JdbcTemplate jdbcTemplate) {
//    return new JdbcSpitterRepository(jdbcTemplate);
//  }
//
////  @Bean
////  public SpittleRepository spittleRepository(JdbcTemplate jdbcTemplate) {
////    return new JdbcSpittleRepository(jdbcTemplate);
////  }
//
//  @Bean
//  public PlatformTransactionManager transactionManager(DataSource dataSource) {
//    return new DataSourceTransactionManager(dataSource);
//  }
//
//}
