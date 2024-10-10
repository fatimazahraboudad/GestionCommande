package com.project.orders_service.feignClient;

import com.project.orders_service.dto.UserDto;
import com.project.orders_service.exception.SomethingWrongException;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeoutException;

@Component
@Slf4j
public class FallBackFactoryUser implements FallbackFactory<OrderUserFeignClient> {
    @Override
    public OrderUserFeignClient create(Throwable cause) {
        return new OrderUserFeignClient() {
            @Override
            public ResponseEntity<UserDto> getUserById(String idUser) {

                throw  new SomethingWrongException();

            }
        };
    }
}