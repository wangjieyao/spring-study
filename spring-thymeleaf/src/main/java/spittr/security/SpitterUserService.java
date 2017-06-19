package spittr.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.userdetails.UserDetails;
import spittr.Spitter;
import spittr.data.SpitterRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO ADD DESCRIPTION
 *
 * @author wangjieyao
 * @Date 2017/6/19 17:09
 */
public class SpitterUserService implements UserDetailsService{

    private SpitterRepository spitterRepository;

    public SpitterUserService(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //查找spitter
        Spitter spitter = spitterRepository.findByUsername(username);
        if (spitter != null){
            List<GrantedAuthority> authorities = new ArrayList<>();
            //创建权限列表
            authorities.add(new SimpleGrantedAuthority("ROLE_SPITTER"));
            //返回user
            return new User(spitter.getUsername(),spitter.getPassword(),authorities);
        }
        throw new UsernameNotFoundException("User '"+username+"' not found");
    }
}
