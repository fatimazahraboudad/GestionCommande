package com.project.users_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "utilisateur")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class User {

    @Id
    private String idUser;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String password;


}
