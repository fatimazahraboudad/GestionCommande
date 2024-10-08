package com.project.orders_service.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "orderLine")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class OrderLine {

    @Id
    private String idOrderLine;
    private String idProduct;
    private int quantity;
    @ManyToOne
    private Order order;

}
