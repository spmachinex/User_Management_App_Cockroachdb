package com.becoder.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "users")
public class UserDtls {

    @Id
    private String id;

    private String fullName;

    private String email;

    private String address;

    private String qualification;

    private String password;

    private String role;
}
