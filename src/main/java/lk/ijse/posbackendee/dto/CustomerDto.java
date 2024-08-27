package lk.ijse.posbackendee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDto {
    private String C_id;
    private String name;
    private String address;
    private Integer contact;
}
