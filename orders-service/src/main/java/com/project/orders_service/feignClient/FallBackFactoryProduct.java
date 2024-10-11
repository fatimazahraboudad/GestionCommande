package com.project.orders_service.feignClient;

import com.project.orders_service.dto.OrderLineDto;
import com.project.orders_service.exception.SomethingWrongException;
import com.project.orders_service.feingClientReturn.ResponseFeign;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class FallBackFactoryProduct implements FallbackFactory<OrderProductFeignClient> {
    @Override
    public OrderProductFeignClient create(Throwable cause) {
        return new OrderProductFeignClient() {


            @Override
            public ResponseFeign checkProductInStock(String query) {
                throw new SomethingWrongException();
            }

            @Override
            public void decrementQuantityOfProduct(String query) {
                throw new SomethingWrongException();

            }


        };
    }
}
