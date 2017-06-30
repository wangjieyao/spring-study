package orders.db.order;

import orders.bean.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * TODO ADD DESCRIPTION
 *
 * @author wangjieyao
 * @Date 2017/6/23 18:02
 */
public class OrderRepositoryImpl implements  OrderOperations{
    @Autowired
    @Qualifier(value = "testTemplate")
    private MongoTemplate mongo;

    @Override
    public List<Order> findOrderByType(String t) {
        String type  = t.equals("NET") ? "WEB" :t;
        Criteria where = Criteria.where("type").is(type);
        Query query = Query.query(where);
        return mongo.find(query,Order.class);
    }
}
