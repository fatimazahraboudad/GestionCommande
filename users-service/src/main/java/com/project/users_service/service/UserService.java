package com.project.users_service.service;

import com.project.users_service.dto.UserRequest;
import com.project.users_service.dto.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse addUser(UserRequest userRequest);

    List<UserResponse> listOfUser();

    List<UserResponse> listOfUserPageable(int pageNo, int pageSize);

    UserResponse getUserById(String idUser);
    UserResponse updateUser(UserRequest userRequest);
    String deleteUser(String idUser);



}
