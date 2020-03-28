package km.exam7.foodorders.repository;

import km.exam7.foodorders.model.Order;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderRepository extends PagingAndSortingRepository<Order, String> {
}
