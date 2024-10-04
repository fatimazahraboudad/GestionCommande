package com.project.users_service.service;

import com.project.users_service.dto.UserRequest;
import com.project.users_service.dto.UserResponse;
import com.project.users_service.entity.User;
import com.project.users_service.exception.AlreadyExistException;
import com.project.users_service.exception.UserNotFoundException;
import com.project.users_service.mapper.UserMapper;
import com.project.users_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.control.MappingControl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public UserResponse addUser(UserRequest userRequest) {
        if(getUserByEmail(userRequest.getEmail())){
            throw new AlreadyExistException();
        }

        User userToSave = UserMapper.mapper.userRequestToUser(userRequest);
        userToSave.setIdUser(UUID.randomUUID().toString());
        return UserMapper.mapper.userToUserResponse(userRepository.save(userToSave));
    }

    @Override
    public List<UserResponse> listOfUser() {
        return UserMapper.mapper.usersToUserResponses(userRepository.findAll());
    }

    @Override
    public UserResponse getUserById(String idUser) {
        return UserMapper.mapper.userToUserResponse(helper(idUser));

    }

    @Override
    public UserResponse updateUser(UserRequest userRequest) {
        User user = helper(userRequest.getIdUser());
        user.setUserName(userRequest.getUserName());
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setPassword(userRequest.getPassword());

        return UserMapper.mapper.userToUserResponse(userRepository.save(user));
    }

    @Override
    public String deleteUser(String idUser) {

        userRepository.delete(helper(idUser));
        return "user deleted";
    }

    public User helper(String idUser){
        return userRepository.findById(idUser).orElseThrow(
                UserNotFoundException::new);
    }
    public boolean getUserByEmail(String email){
        Optional<User> user= userRepository.findByEmail(email);
        return user.isPresent();
    }


}
