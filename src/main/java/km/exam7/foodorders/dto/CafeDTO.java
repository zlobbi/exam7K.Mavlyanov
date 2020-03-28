package km.exam7.foodorders.dto;

import km.exam7.foodorders.model.Cafe;
import lombok.*;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class CafeDTO {
    private String name;
    private String description;

    public static CafeDTO from(Cafe c) {
        return builder()
                .name(c.getName())
                .description(c.getDescription())
                .build();
    }
}
