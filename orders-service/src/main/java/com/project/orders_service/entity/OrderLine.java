package com.project.orders_service.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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

    private String idOrderLine;
    private String idProduct;
    private int quantity;

    @ManyToOne
    private Order order;

}
