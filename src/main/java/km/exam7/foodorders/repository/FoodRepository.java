package km.exam7.foodorders.repository;

import km.exam7.foodorders.model.Food;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FoodRepository extends PagingAndSortingRepository<Food, String> {
    Slice<Food> findAllByCafeId(String placeName, Pageable pageable);
    Food findByName(String foodName);

    boolean existsByName(String foodName);
}
