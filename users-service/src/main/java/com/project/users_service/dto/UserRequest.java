package com.project.users_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserRequest {

    private String idUser;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
