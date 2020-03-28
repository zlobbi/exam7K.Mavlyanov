package km.exam7.foodorders.repository;

import km.exam7.foodorders.model.Cafe;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CafeRepository extends PagingAndSortingRepository<Cafe, String> {
}
