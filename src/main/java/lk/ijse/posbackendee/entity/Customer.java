package lk.ijse.posbackendee.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {
    private String C_id;
    private String name;
    private String address;
    private Integer contact;

    public Customer(String name,String address,Integer contact){
        this.name = name;
        this.address = address;
        this.contact = contact;

    }
}
