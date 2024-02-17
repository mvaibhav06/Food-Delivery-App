package com.codedecode.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodItemsDTO {
    private int id;
    private String item;
    private String itemDescription;
    private boolean isVeg;
    private Number price;
    private Integer restaurentId;
    private Integer quantity;
}
