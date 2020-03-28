package km.exam7.foodorders.controller;

import km.exam7.foodorders.annotations.ApiPageable;
import km.exam7.foodorders.dto.FoodDTO;
import km.exam7.foodorders.dto.OrderDTO;
import km.exam7.foodorders.model.Client;
import km.exam7.foodorders.repository.ClientRepository;
import km.exam7.foodorders.service.FoodService;
import km.exam7.foodorders.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private final ClientRepository clientRepository;

    public OrderController(OrderService orderService, ClientRepository clientRepository) {
        this.orderService = orderService;
        this.clientRepository = clientRepository;
    }

    @ApiPageable
    @RequestMapping
    public Slice<OrderDTO> getClientOrders(@ApiIgnore Pageable pageable) {
        return orderService.findOrdersForAuthUser(pageable);
    }

//    @ApiPageable
//    @RequestMapping("/place")
//    public Slice<FoodDTO> getPlaceFoods(@ApiIgnore Pageable pageable, @RequestParam("placeId") String placeId) {
//        return foodService.findAllByCafeId(pageable, placeId);
//    }

//    public Client getClient() {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        return clientRepository.findByEmail(auth.getName()).get();
//    }
}
