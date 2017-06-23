package orders.db;

import java.util.List;


import orders.bean.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface OrderRepository extends MongoRepository<Order, String> , OrderOperations {

	List<Order> findByCustomer(String customer);

	List<Order> findByCustomerLike(String customer);

    @Query("{customer:?0,type:?1}")
	List<Order> findByCustomerAndType(String customer, String type);

	@Query("{customer:'Chuck Wagon'}")
	List<Order> findChucksOrders();

}
