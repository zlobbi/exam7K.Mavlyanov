package km.exam7.foodorders.dto;

import km.exam7.foodorders.model.Food;
import lombok.*;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class FoodDTO {
    private String cafeName;
    private String name;
    private String type;
    private double price;

    public static FoodDTO from(Food f) {
        return builder()
                .cafeName(f.getCafe().getName())
                .name(f.getName())
                .type(f.getType())
                .price(f.getPrice())
                .build();
    }
}
