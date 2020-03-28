package km.exam7.foodorders.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Document(collection = "orders")
public class Order {
    @Id
    private String id = UUID.randomUUID().toString();
    private Client client;
    private Food f;
    private LocalDate date;
}
