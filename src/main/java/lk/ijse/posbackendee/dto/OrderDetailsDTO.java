package lk.ijse.posbackendee.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class OrderDetailsDTO {
    private String orderId;
    private String itemId;
    private Integer qty;
}

