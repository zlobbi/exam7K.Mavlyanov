package km.exam7.foodorders.dto;

import km.exam7.foodorders.model.Order;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class OrderDTO {
    private String orderFrom;
    private String foodName;
    private LocalDate orderDate;

    public static OrderDTO from(Order c) {
        return builder()
                .orderFrom(c.getF().getCafe().getName())
                .foodName(c.getF().getName())
                .orderDate(c.getDate())
                .build();
    }
}
