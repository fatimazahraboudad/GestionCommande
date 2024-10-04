package com.project.orders_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "order")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Order {

    private String idOrder;
    @OneToMany(mappedBy = "order")
    private List<OrderLine> ordersLine;
    private String idUser;

}
