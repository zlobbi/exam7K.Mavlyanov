package km.exam7.foodorders.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Random;
import java.util.UUID;

@Data
@Document(collection = "foods")
public class Food {
    private static Random r = new Random();
    @Id
    private String id = UUID.randomUUID().toString();
    private String name;
    private String type;
    private double price;

    public static Food make(String name, String type) {
        Food f = new Food();
        double d = 20.0;
        f.setName(name);
        f.setType(type);
        f.setPrice(20 + (40 - 20) * r.nextDouble());
        return f;
    }
}
