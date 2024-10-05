package com.project.users_service.service;

import com.project.users_service.dto.UserRequest;

public interface KeycloakService {
    boolean createUserKeycloak(UserRequest userRequest);
}
