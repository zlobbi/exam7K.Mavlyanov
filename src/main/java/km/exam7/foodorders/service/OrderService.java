package km.exam7.foodorders.service;

import km.exam7.foodorders.dto.CafeDTO;
import km.exam7.foodorders.dto.OrderDTO;
import km.exam7.foodorders.model.Client;
import km.exam7.foodorders.repository.ClientRepository;
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

    public OrderService(OrderRepository orderRepository, ClientRepository clientRepository) {
        this.orderRepository = orderRepository;
        this.clientRepository = clientRepository;
    }

    public Slice<OrderDTO> findOrdersForAuthUser(Pageable pageable) {
        var slice = orderRepository.findAllByClientId(pageable, getClient().getId());
        return slice.map(OrderDTO::from);
    }

    public Client getClient() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return clientRepository.findByEmail(auth.getName()).get();
    }
}
