package km.exam7.foodorders.repository;

import km.exam7.foodorders.model.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderRepository extends PagingAndSortingRepository<Order, String> {
    Slice<Order> findAllByClientId(Pageable pageable, String id);
}
