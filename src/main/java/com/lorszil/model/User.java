package com.lorszil.model;

import com.lorszil.model.Roles;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "`user`")
@Data
@ToString(exclude = {"password", "token"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String email;
    private String password;
    private String token;

    @Enumerated(value = EnumType.STRING)
    private Roles role;

    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
