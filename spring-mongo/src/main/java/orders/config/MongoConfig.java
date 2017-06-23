package orders.config;

import com.mongodb.Mongo;
import orders.bean.Order;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * TODO ADD DESCRIPTION
 *
 * @author wangjieyao
 * @Date 2017/6/21 16:45
 */
@Configuration
//启用MongoDB的repository功能
@EnableMongoRepositories(basePackageClasses = Order.class)
public class MongoConfig {
    @Bean //mongodb client bean
    public MongoClientFactoryBean mongo(){
        MongoClientFactoryBean mongo = new MongoClientFactoryBean();
//        mongo.setHost("127.0.0.1");
        return mongo;
    }

    @Bean //mongodb template bean
    public MongoOperations mongoTemplate(Mongo mongo){
        return new MongoTemplate(mongo,"test");
    }
}
