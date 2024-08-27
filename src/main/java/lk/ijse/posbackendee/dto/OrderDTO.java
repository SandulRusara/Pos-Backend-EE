package lk.ijse.posbackendee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO {
    private String orderId;
    private LocalDate date;
    private Integer discount;
    private Double total;
    private String C_id;
}
