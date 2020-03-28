package km.exam7.foodorders.controller;

import km.exam7.foodorders.service.ClientService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PutMapping("/register")
    public String registerUser(@RequestParam String email, @RequestParam String name, @RequestParam String password) {
        return clientService.addClient(name, email, password);
    }
}
