package km.exam7.foodorders.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

@Data
@Document(collection = "orders")
public class Order {
    @Id
    private String id = UUID.randomUUID().toString();
    @DBRef
    private Client client;
    @DBRef
    private Food f;
    private LocalDateTime date;

    public static Order make(Client client, Food f) {
        int r = new Random().nextInt(2);
        LocalDateTime d = LocalDateTime.now();
        Order o = new Order();
        o.setClient(client);
        o.setF(f);
        o.setDate(d);
        return o;
    }
}
