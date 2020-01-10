package com.isa.domain.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "email")
    private String email;

    @Column(name = "user_type")
    private UserType userType;

    @ManyToMany
    @JoinColumn(name = "favorities" )
    private List<Favorities> favorities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public List<Favorities> getFavorities() {
        return favorities;
    }

    public void setFavorities(List<Favorities> favorities) {
        this.favorities = favorities;
    }
}
