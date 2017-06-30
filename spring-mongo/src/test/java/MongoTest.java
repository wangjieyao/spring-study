import orders.bean.Item;
import orders.bean.Order;
import orders.config.MongoConfig;
import orders.config.MongoConfig1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.LinkedHashSet;

/**
 * TODO ADD DESCRIPTION
 *
 * @author wangjieyao
 * @Date 2017/6/22 20:26
 */
//@ContextConfiguration(classes=MongoConfig1.class)
@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class MongoTest {

    @Autowired
    @Qualifier(value = "projectTemplate")
    private MongoOperations projectOperaions;

    @Autowired
    @Qualifier(value = "testTemplate")
    private MongoTemplate mongo1;

    @Test
    public void testMongo(){
        Order order = createOrder();
        mongo1.save(order,"order");
    }

    @Test
    public void testSearchMongo(){
        long count = mongo1.getCollection("order").count();
        System.out.println(count);
        Order order = mongo1.findById(1,Order.class);
        System.out.println("Price:"+order.getPrice());
        testProject();
    }

    public void testProject(){
        long count = projectOperaions.getCollection("project").count();
        System.out.println(count);
    }

    private Order createOrder(){
        Order order = new Order();
        order.setId(1l);
        order.setCustomer("Jack");
        order.setType("stationery");
        Item item1 = new Item();
        item1.setId(1l);
        item1.setPrice(10.0);
        item1.setProduct("pen");
        item1.setQuantity(1);
        Item item2 = new Item();
        item2.setId(2l);
        item2.setProduct("book");
        item2.setQuantity(2);
        item2.setPrice(20.0);
        LinkedHashSet set = new LinkedHashSet();
        set.add(item1);
        set.add(item2);
        order.setItems(set);
        order.setPrice(item1.getPrice()*item1.getQuantity()+item2.getPrice()*item2.getQuantity());
        return order;
    }
}
