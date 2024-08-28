package lk.ijse.posbackendee.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Item {
    private String itemId;
    private String description;
    private Double unitPrice;
    private Integer qty;

    public Item(String description,Double unitPrice,Integer qty){
        this.description = description;
        this.unitPrice = unitPrice;
        this.qty = qty;

    }
}

