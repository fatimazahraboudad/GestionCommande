package com.project.orders_service.feignClient;

import com.project.orders_service.dto.OrderLineDto;
import com.project.orders_service.exception.SomethingWrongException;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FallBackFactoryProduct implements FallbackFactory<OrderProductFeignClient> {
    @Override
    public OrderProductFeignClient create(Throwable cause) {
        return new OrderProductFeignClient() {
            @Override
            public boolean checkProductInStock(List<OrderLineDto> orderLineDtos) {
                throw new SomethingWrongException();

            }

            @Override
            public String decrementQuantityOfProduct(List<OrderLineDto> orderLineDtos) {
                throw new SomethingWrongException();
            }
        };
    }
}
