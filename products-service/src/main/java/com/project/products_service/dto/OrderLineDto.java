package com.project.products_service.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class OrderLineDto {

    private String idOrderLine;
    private String idProduct;
    private int quantity;

    private String idOrder;

}