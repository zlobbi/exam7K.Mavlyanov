package km.exam7.foodorders.controller;

import km.exam7.foodorders.annotations.ApiPageable;
import km.exam7.foodorders.dto.FoodDTO;
import km.exam7.foodorders.service.FoodService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/foods")
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @ApiPageable
    @RequestMapping
    public Slice<FoodDTO> getAllFoods(@ApiIgnore Pageable pageable) {
        return foodService.findAllFoods(pageable);
    }

    @ApiPageable
    @RequestMapping("/place")
    public Slice<FoodDTO> getPlaceFoods(@ApiIgnore Pageable pageable, @RequestParam("placeId") String placeId) {
        return foodService.findAllByCafeId(pageable, placeId);
    }

//    @RequestMapping("/order")
//    public FoodDTO orderFood(@RequestParam("foodName") String foodName) {
//        return foodService.findFoodByName(foodName.trim());
//    }
}
