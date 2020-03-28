package km.exam7.foodorders.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document(collection = "clients")
public class Client {

    @Id
    private String id = UUID.randomUUID().toString();
    private String name;
    private String email;

    public static Client make(String name, String email) {
        Client c = new Client();
        c.setName(name);
        c.setEmail(email);
        return c;
    }
}
