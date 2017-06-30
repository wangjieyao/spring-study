package orders.db.order;

import orders.bean.Order;

import java.util.List;

/**
 * TODO ADD DESCRIPTION
 *
 * @author wangjieyao
 * @Date 2017/6/23 18:00
 */
public interface OrderOperations {

    List<Order> findOrderByType(String type);
}
