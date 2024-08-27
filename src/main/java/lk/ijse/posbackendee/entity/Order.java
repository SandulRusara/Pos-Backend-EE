package lk.ijse.posbackendee.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order {
    private String orderId;
    private LocalDate date;
    private Integer discount;
    private Double total;
    private String C_id;
}
