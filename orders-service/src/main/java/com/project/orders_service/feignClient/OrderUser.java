package com.project.orders_service.feignClient;

import com.project.orders_service.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "users-service")
public interface OrderUser {

    @GetMapping("user/{idUser}")
    public ResponseEntity<UserDto> getUserById(@PathVariable String idUser);
}
