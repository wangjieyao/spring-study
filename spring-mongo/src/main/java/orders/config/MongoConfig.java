package orders.config;

import com.mongodb.Mongo;
import com.mongodb.MongoCredential;
import orders.bean.Order;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
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
//        MongoCredential mongoCredential = new MongoCredential(new );
//        mongo.setHost("127.0.0.1");
//        mongo.setCredentials();
//        return new SimpleMongoDbFactory(MongoClients.create("mongodb://joe:secret@localhost"), "database", userCredentials);
        return mongo;
    }

    @Bean //mongodb client bean
    public MongoClientFactoryBean mongo2(){
        MongoClientFactoryBean mongo = new MongoClientFactoryBean();
//        mongo.setHost("127.0.0.1");
        return mongo;
    }

//    @Bean //mongodb template bean
//    public MongoOperations testTemplate(Mongo mongo){
//        UserCredentials userCredentials = new UserCredentials("test","123456");
//        return new MongoTemplate(mongo,"test",userCredentials);
//    }

    @Bean //mongodb template bean
    public MongoOperations projectTemplate(Mongo mongo2){
        UserCredentials userCredentials = new UserCredentials("show1","123456");
        return new MongoTemplate(mongo2,"show1",userCredentials);
    }

//    public @Bean ReactiveMongoDatabaseFactory mongoDatabaseFactory() {
//        return new SimpleMongoDbFactory(MongoClients.create("mongodb://joe:secret@localhost"), "database", userCredentials);
//    }
//
//    public @Bean ReactiveMongoTemplate reactiveMongoTemplate() {
//        return new ReactiveMongoTemplate(mongoDatabaseFactory());
//    }
}
