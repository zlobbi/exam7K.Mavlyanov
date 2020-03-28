package km.exam7.foodorders.repository;

import km.exam7.foodorders.model.Client;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ClientRepository extends PagingAndSortingRepository<Client, String> {
}
