package orders.db.project;

import orders.bean.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 * 项目数据操作实现
 *
 * @author wangjieyao
 * @Date 2017/6/12 15:19
 */
public class ProjectRepositoryImpl implements ProjectRepositoryCustom {

    @Autowired
    @Qualifier(value = "projectTemplate")
    private MongoTemplate mongoTemplate;

    @Override
    public Project getProjectByName(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        return  mongoTemplate.findOne(query,Project.class);
    }

    @Override
    public Project getProjectByKey(String key) {
        Query query = new Query();
        query.addCriteria(Criteria.where("key").is(key));
        return mongoTemplate.findOne(query,Project.class);
    }

}
