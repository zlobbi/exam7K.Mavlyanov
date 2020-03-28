package km.exam7.foodorders.service;

import km.exam7.foodorders.model.Client;
import km.exam7.foodorders.repository.ClientRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAuthService implements UserDetailsService {

    private final ClientRepository repo;

    public UserAuthService(ClientRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Client> client = repo.findByEmail(s);
        if (client.isPresent())
                return client.get();

        throw new UsernameNotFoundException("User does not exit");
    }


}
