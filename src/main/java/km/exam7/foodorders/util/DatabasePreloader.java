package km.exam7.foodorders.util;

import km.exam7.foodorders.model.Cafe;
import km.exam7.foodorders.model.Food;
import km.exam7.foodorders.repository.CafeRepository;
import km.exam7.foodorders.repository.ClientRepository;
import km.exam7.foodorders.repository.FoodRepository;
import km.exam7.foodorders.repository.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class DatabasePreloader {
    private Random r = new Random();

    @Bean
    CommandLineRunner generateGibberish(CafeRepository cafeRepository, ClientRepository clientRepository,
                                        FoodRepository foodRepository, OrderRepository orderRepository) {
        return args -> {
            // cafe repo initialization
            for(GenerateData.PlaceName pn : GenerateData.getPlaceNames()) {
                Cafe c = new Cafe();
                c.setName(pn.name);
                c.setDescription(pn.description);
                cafeRepository.save(c);
            }

            // food repository initialization
            for(GenerateData.DishName dn : GenerateData.getDishNames()) {
                Food f = new Food();
                f.setName(dn.getName());
                f.setType(dn.getType());
                foodRepository.save(f);
            }

            cafeRepository.findAll().forEach(c -> System.out.println(c));
            foodRepository.findAll().forEach(f -> System.out.println(f));

        };
    }
}
