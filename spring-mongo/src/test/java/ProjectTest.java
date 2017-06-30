import orders.bean.Order;
import orders.config.MongoConfig;
import orders.config.MongoConfig1;
import orders.db.block.BlockRepository;
import orders.db.order.OrderRepository;
import orders.db.project.ProjectRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * TODO ADD DESCRIPTION
 *
 * @author wangjieyao
 * @Date 2017/6/26 13:59
 */
@ContextConfiguration()
//@ContextConfiguration(classes=MongoConfig1.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class ProjectTest {

    @Autowired
    @Qualifier(value = "projectTemplate")
    private MongoTemplate mongoTemplate2;

    @Autowired
    @Qualifier(value = "testTemplate")
    private MongoTemplate testTemplate;


    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private BlockRepository blockRepository;

    @Test
    public void testProject(){
//        Long count = mongoTemplate2.getCollection("project").count();
//        System.out.println(count);
        long count = projectRepository.count();
        System.out.println(count);
        Order order = orderRepository.findOne(1l);
        System.out.println(order.getPrice());
        long count1 = blockRepository.count();
        System.out.println(count1);

    }

    @Test
    public void testSearchMongo(){
        long count = testTemplate.getCollection("order").count();
        System.out.println(count);
        Order order = testTemplate.findById(1,Order.class);
        System.out.println("Price:"+order.getPrice());
    }

}
