package km.exam7.foodorders.service;

import km.exam7.foodorders.model.Client;
import km.exam7.foodorders.repository.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public String addClient(String name, String email, String password) {
        String msg = "";
        if(!clientRepository.existsByNameAndEmail(name, email)) {
            Client u = Client.make(name, email, password);
            clientRepository.save(u);
            msg = "User " + name + " registered, " + "Id: " + u.getId();
        } else {
            msg = "User " + name + " already exists!";
        }
        return msg;
    }

}
