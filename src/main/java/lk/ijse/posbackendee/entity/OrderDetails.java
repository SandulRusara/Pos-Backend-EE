package lk.ijse.posbackendee.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class OrderDetails {
    private String orderId;
    private String itemId;
    private Integer qty;
}

