package km.exam7.foodorders.service;

import km.exam7.foodorders.dto.OrderDTO;
import km.exam7.foodorders.model.Client;
import km.exam7.foodorders.model.Food;
import km.exam7.foodorders.model.Order;
import km.exam7.foodorders.repository.ClientRepository;
import km.exam7.foodorders.repository.FoodRepository;
import km.exam7.foodorders.repository.OrderRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;
    private final FoodRepository foodRepository;

    public OrderService(OrderRepository orderRepository, ClientRepository clientRepository, FoodRepository foodRepository) {
        this.orderRepository = orderRepository;
        this.clientRepository = clientRepository;
        this.foodRepository = foodRepository;
    }

    public Slice<OrderDTO> findOrdersForAuthUser(Pageable pageable) {
        var slice = orderRepository.findAllByClientId(pageable, getClient().getId());
        return slice.map(OrderDTO::from);
    }

    public String addOrderForClient(String foodName) {
        String msg;
        if(foodRepository.existsByName(foodName)) {
            Food f = foodRepository.findByName(foodName);
            Order o = Order.make(getClient(), f);
            orderRepository.save(o);
            msg = "Order: " + f.getName() + " Time: " + o.getDate();
        } else {
            msg = "Food: " + foodName + " not found";
        }
        return msg;
    }

    public Client getClient() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return clientRepository.findByEmail(auth.getName()).get();
    }
}
