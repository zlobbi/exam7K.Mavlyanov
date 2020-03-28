package km.exam7.foodorders.service;

import km.exam7.foodorders.dto.FoodDTO;
import km.exam7.foodorders.model.Food;
import km.exam7.foodorders.repository.FoodRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
public class FoodService {

    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public Slice<FoodDTO> findAllFoods(Pageable pageable) {
        var slice = foodRepository.findAll(pageable);
        return slice.map(FoodDTO::from);
    }

    public Slice<FoodDTO> findAllByCafeId(Pageable pageable, String placeName) {
        var slice = foodRepository.findAllByCafeId(placeName, pageable);
        return slice.map(FoodDTO::from);
    }

    public FoodDTO findFoodByName(String foodName) {
        var f = foodRepository.findByName(foodName);
        return FoodDTO.from(f);
    }
}
