package com.project.users_service.mapper;

import com.project.users_service.dto.UserRequest;
import com.project.users_service.dto.UserResponse;
import com.project.users_service.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper mapper = Mappers.getMapper(UserMapper.class);

    User userRequestToUser(UserRequest userRequest);
    UserResponse userToUserResponse(User user);
    List<UserResponse> usersToUserResponses(List<User> users);



}
