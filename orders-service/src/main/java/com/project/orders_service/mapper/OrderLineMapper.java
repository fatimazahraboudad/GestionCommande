package com.project.orders_service.mapper;

import com.project.orders_service.dto.OrderLineDto;
import com.project.orders_service.entity.OrderLine;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderLineMapper {

    OrderLineMapper mapper = Mappers.getMapper(OrderLineMapper.class);

    OrderLine orderLineDtoToOrderLine(OrderLineDto orderLineDto);
    OrderLineDto OrderLineToOrderLineDto(OrderLine orderLine);
}
