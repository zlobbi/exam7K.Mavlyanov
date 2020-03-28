package km.exam7.foodorders.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "cafes")
public class Cafe {
    @Id
    private String id;
    private String name;
    private String description;

    public static Cafe make(String name, String description) {
        Cafe c = new Cafe();
        c.setName(name);
        c.setDescription(description);
        return c;
    }
}
