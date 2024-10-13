package com.project.orders_service.dto;

import com.project.orders_service.entity.OrderLine;
import com.project.orders_service.validation.AddGroup;
import com.project.orders_service.validation.UpdateGroup;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class OrderDto {

    @Null(groups = AddGroup.class, message = "idOrder must be null for add operations")
    @NotNull(groups = UpdateGroup.class, message = "idOrder must not be null for update operations")
    private String idOrder;
    private List<OrderLineDto> ordersLine;
    private UserDto userDto;

}
