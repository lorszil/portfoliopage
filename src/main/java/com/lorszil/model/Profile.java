package com.lorszil.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
public class Profile {

    @OneToOne
    @JoinColumn(name = "`user`", unique = true)
    @NotNull
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String email;


    public Profile() {
    }

    public Profile(User user) {
        this.user = user;
        this.email = user.getEmail();
    }
}
