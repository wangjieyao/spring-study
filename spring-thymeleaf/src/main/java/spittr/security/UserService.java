package spittr.security;

/**
 * TODO ADD DESCRIPTION
 *
 * @author wangjieyao
 * @Date 2017/6/19 17:10
 */
public interface UserService {
    UserDetails loadUserByUsername(String username) throws UserNotFoundException;
}
