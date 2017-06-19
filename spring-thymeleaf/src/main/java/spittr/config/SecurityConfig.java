package spittr.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import spittr.data.SpitterRepository;
import spittr.security.SpitterUserService;

import javax.sql.DataSource;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//  @Override
//  protected void configure(HttpSecurity http) throws Exception {
//    http
//      .formLogin()
//        .loginPage("/login")
//      .and()
//        .logout()
//          .logoutSuccessUrl("/")
//      .and()
//      .rememberMe()
//        .tokenRepository(new InMemoryTokenRepositoryImpl())
//        .tokenValiditySeconds(2419200)
//        .key("spittrKey")
//      .and()
//       .httpBasic()
//         .realmName("Spittr")
//      .and()
//      .authorizeRequests()
//        .antMatchers("/").authenticated()
//        .antMatchers("/spitter/me").authenticated()
//        .antMatchers(HttpMethod.POST, "/spittles").authenticated()
//        .anyRequest().permitAll();
//  }

    /**
     * 基于内存的用户存储
     * @param auth
     * @throws Exception
     */
//  @Override
//  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//    auth
//      .inMemoryAuthentication()
//            .withUser("user").password("password").roles("USER").and()
//            .withUser("admin").password("password").roles("USER","ADMIN");
//  }
//
 /* @Autowired
  private DataSource dataSource;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    //自定义查询，查询用户信息 权限 设置密码转码器
    auth.jdbcAuthentication().dataSource(dataSource)
            .usersByUsernameQuery("select username,password,true from spitter where username=?")
            .authoritiesByUsernameQuery("select username,'ROLE_USER' from spitter where username=?");
//    .passwordEncoder(new StandardPasswordEncoder("53cr3t"));
  }*/

    @Autowired
    SpitterRepository spitterRepository;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //使用SpitterUserService进行用户认证
        auth.userDetailsService(new SpitterUserService(spitterRepository));
    }



}
