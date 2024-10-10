package com.project.orders_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Order {

    @Id
    private String idOrder;
    @OneToMany(mappedBy = "order", cascade = CascadeType.MERGE)
    private List<OrderLine> ordersLine;
    private String idUser;
    private boolean deleted;

}
