package km.exam7.foodorders.repository;

import km.exam7.foodorders.model.Client;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface ClientRepository extends PagingAndSortingRepository<Client, String> {
    Optional<Client> findByEmail(String s);

    boolean existsByNameAndEmail(String name, String email);
}
