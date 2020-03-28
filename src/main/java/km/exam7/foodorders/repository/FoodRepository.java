package km.exam7.foodorders.repository;

import km.exam7.foodorders.model.Food;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FoodRepository extends PagingAndSortingRepository<Food, String> {
}
