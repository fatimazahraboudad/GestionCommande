package com.project.users_service.controller;

import com.project.users_service.dto.UserRequest;
import com.project.users_service.dto.UserResponse;
import com.project.users_service.repository.UserRepository;
import com.project.users_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> addUser(@RequestBody UserRequest userResponse) {
            UserResponse userResponse1 =userService.addUser(userResponse);
            return new ResponseEntity<>(userResponse1, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> gelAllUser() {
        return ResponseEntity.ok(userService.listOfUser());
    }

    @GetMapping("/{idUser}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable String idUser) {
        return ResponseEntity.ok(userService.getUserById(idUser));
    }

    @GetMapping("/{pageNumber}/{pageSize}")
    public ResponseEntity<List<UserResponse>> getUses(@PathVariable int pageNumber, @PathVariable int pageSize) {
        return ResponseEntity.ok(userService.listOfUserPageable(pageNumber,pageSize));
    }

    @PutMapping
    public ResponseEntity<UserResponse> updateUser(@RequestBody UserRequest userResponse) {
        UserResponse userResponse1 =userService.updateUser(userResponse);
        return new ResponseEntity<>(userResponse1, HttpStatus.OK);
    }


    @DeleteMapping("/{idUser}")
    public ResponseEntity<String> deleteUserById(@PathVariable String idUser) {
        return ResponseEntity.ok(userService.deleteUser(idUser));
    }
}
