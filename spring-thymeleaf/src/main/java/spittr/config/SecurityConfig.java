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

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .formLogin()
        .loginPage("/login")
      .and()
        .logout()
          .logoutSuccessUrl("/")
      .and()
      .rememberMe()
        .tokenRepository(new InMemoryTokenRepositoryImpl())
        .tokenValiditySeconds(2419200)
        .key("spittrKey")
      .and()
       .httpBasic()
         .realmName("Spittr")
      .and()
      .authorizeRequests()
        .antMatchers("/").authenticated()
        .antMatchers("/spitter/me").authenticated()
        .antMatchers(HttpMethod.POST, "/spittles").authenticated()
        .anyRequest().permitAll();
  }

   /* *//**
     * 基于内存的用户存储
     * @param auth
     * @throws Exception
     *//*
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth
      .inMemoryAuthentication()
            .withUser("user").password("password").roles("USER").and()
            .withUser("admin").password("password").roles("USER","ADMIN");
  }*/

  @Autowired
  private DataSource dataSource;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    //自定义查询，查询用户信息 权限 设置密码转码器
    auth.jdbcAuthentication().dataSource(dataSource)
            .usersByUsernameQuery("select username,password,true from spitter where username=?")
            .authoritiesByUsernameQuery("select username,'ROLE_USER' from spitter where username=?");
//    .passwordEncoder(new StandardPasswordEncoder("53cr3t"));
  }

/*
    *//**
     * 配置自定义的用户认证服务
     *//*
    @Autowired
    SpitterRepository spitterRepository;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //使用SpitterUserService进行用户认证
        auth.userDetailsService(new SpitterUserService(spitterRepository));
    }*/

   /* @Override
    protected void configure(HttpSecurity http) throws Exception {
        //指明/spiters*//** /spittles/mine  /spittles的pos方法需要进行认证，其他请求不需要
//        http.authorizeRequests().antMatchers("/spiters*//**","/spittles/mine").authenticated()
//                .antMatchers(HttpMethod.POST,"/spittles").hasAuthority("ROLE_USER")
//                .anyRequest().permitAll();
//        等价于antMatchers("/spiters*//**"）
//        http.authorizeRequests().regexMatchers("/spitters/.*").authenticated().anyRequest().permitAll();


//        http.authorizeRequests().antMatchers("/spitter/me").hasAuthority("ROLE_USER")
//                .antMatchers(HttpMethod.POST,"/spittles").authenticated()
//                .anyRequest().permitAll();

        http .formLogin()//启用默认的登录页面
        .loginPage("/login").and()
        .logout().logoutSuccessUrl("/").and()
        *//*.rememberMe().tokenValiditySeconds(2419200).key("spitterkey").and()//启用remember-me 有效时间为4周 设置私钥*//*
        .authorizeRequests().antMatchers("/spitter/me")
        .access("hasRole('ROLE_USER') and hasIpAddress('127.0.0.1')")
        .anyRequest().permitAll()
        *//* .and().httpBasic().realmName("Spitter") //启用http basic*//*
        *//*.and()//设置安全通道 会将请求重定向到https
        .requiresChannel().antMatchers("/spitter/me").requiresSecure()*//*;
    }*/
}
