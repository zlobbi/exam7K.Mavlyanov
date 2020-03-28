package km.exam7.foodorders.controller;

import km.exam7.foodorders.annotations.ApiPageable;
import km.exam7.foodorders.dto.OrderDTO;
import km.exam7.foodorders.repository.ClientRepository;
import km.exam7.foodorders.service.OrderService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping
public class OrderController {

    private final OrderService orderService;
    private final ClientRepository clientRepository;

    public OrderController(OrderService orderService, ClientRepository clientRepository) {
        this.orderService = orderService;
        this.clientRepository = clientRepository;
    }

    @ApiPageable
    @RequestMapping("/orders")
    public Slice<OrderDTO> getClientOrders(@ApiIgnore Pageable pageable) {
        return orderService.findOrdersForAuthUser(pageable);
    }

    @PutMapping("/orders/add")
    public String addTaskForUser(@RequestParam String foodName) {
        return orderService.addOrderForClient(foodName);
    }
}
