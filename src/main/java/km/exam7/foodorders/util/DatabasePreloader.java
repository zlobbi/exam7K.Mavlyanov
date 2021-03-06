package km.exam7.foodorders.util;

import km.exam7.foodorders.model.Cafe;
import km.exam7.foodorders.model.Client;
import km.exam7.foodorders.model.Food;
import km.exam7.foodorders.model.Order;
import km.exam7.foodorders.repository.CafeRepository;
import km.exam7.foodorders.repository.ClientRepository;
import km.exam7.foodorders.repository.FoodRepository;
import km.exam7.foodorders.repository.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Configuration
public class DatabasePreloader {
    private Random r = new Random();

    @Bean
    CommandLineRunner generateGibberish(CafeRepository cafeRepository, ClientRepository clientRepository,
                                        FoodRepository foodRepository, OrderRepository orderRepository) {
        return args -> {
            cafeRepository.deleteAll();
            clientRepository.deleteAll();
            foodRepository.deleteAll();
            orderRepository.deleteAll();

            // cafe repo initialization
            List<Cafe> cafes = new ArrayList<>();
            for(int i = 0; i < 6; i++) {
                GenerateData.PlaceName pn = GenerateData.randomPlace();
                Cafe c = Cafe.make(pn.name, pn.description);
                cafes.add(c);
            }

            // food repository initialization
            List<Food> foods = new ArrayList<>();
            for(GenerateData.DishName dn : GenerateData.getDishNames()) {
                var c = cafes.get(r.nextInt(cafes.size()));
                Food f = Food.make(dn.name.trim(), dn.type, c);
                foods.add(f);
            }
            // client repo initialize
            List<Client> clients = new ArrayList<>();
            for(int i = 0; i < 10; i++) {
                var c = GenerateData.randomPersonName();
                Client client = Client.make(c, GenerateData.randomEmail(c),
                        GenerateData.randomPersonName().replace(" ", ""));
                clients.add(client);
            }
            // order repo initialize
            List<Order> orders = new ArrayList<>();
            for(int i = 0; i < 20; i++) {
                var c = clients.get(r.nextInt(clients.size()));
                var f = foods.get(r.nextInt(foods.size()));
                var o = Order.make(c, f);
                orders.add(o);
            }

            cafeRepository.saveAll(cafes);
            foodRepository.saveAll(foods);
            clientRepository.saveAll(clients);
            orderRepository.saveAll(orders);

            cafeRepository.findAll().forEach(c -> System.out.println(c));
            foodRepository.findAll().forEach(f -> System.out.println(f));
            clientRepository.findAll().forEach(c -> System.out.println(c));

        };
    }
}
