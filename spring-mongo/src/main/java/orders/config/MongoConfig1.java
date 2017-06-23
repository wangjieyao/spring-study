//package orders.config;
//
//import com.mongodb.Mongo;
//import com.mongodb.MongoClient;
//import com.mongodb.MongoCredential;
//import com.mongodb.ServerAddress;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
//import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
//
//import java.util.Arrays;
//
///**
// * TODO ADD DESCRIPTION
// *
// * @author wangjieyao
// * @Date 2017/6/21 16:45
// */
//@Configuration
////启用MongoDB的repository功能
//@EnableMongoRepositories(basePackageClasses = "orders.db")
//public class MongoConfig1 extends AbstractMongoConfiguration{
//
//    @Override
//    protected String getDatabaseName() {
//        return "spring_mongo";   //指定数据库名称
//    }
//
////    @Override
////    public Mongo mongo() throws Exception {
////        return new MongoClient("localhost",27017);    //创建mongo客户端
////    }
//
//    @Override
//    public Mongo mongo() throws Exception {
//        //创建mongo 凭证
//        MongoCredential credential = MongoCredential.createCredential("mongo","spring_mongo","123456".toCharArray());
//        return new MongoClient(new ServerAddress("localhost",27017), Arrays.asList(credential));
//    }
//}
