package soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO ADD DESCRIPTION
 *
 * @author wangjieyao
 * @Date 2017/5/19 16:17
 */
@Configuration
public class CDPlayerConfig {

//    @Bean
//    public CompactDisc sgtPeppers(){
//        return new SgtPeppers();
//    }

    @Bean
    public CompactDisc randomBeatlesCD(){
        int choince = (int) (System.currentTimeMillis() %2);
        if (choince ==1){
            return  new SgtPeppers();
        }else {
            return new Qilixiang();
        }
    }


}
