package com.isa.domain.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "user")
public class User {

    @Id
    @Column (name = "id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "email")
    private String email;

    @Column (name = "user_type")
    private UserType userType;

    @ManyToMany (fetch = FetchType.LAZY)
    @JoinTable (name = "user_event",
            joinColumns = @JoinColumn (name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn (name = "event_id", referencedColumnName = "id"))
    private List<Event> favoriteEvents;


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

    public List<Event> getFavoriteEvents() {
        return favoriteEvents;
    }

    public void setFavoriteEvents(List<Event> favoriteEvents) {
        this.favoriteEvents = favoriteEvents;
    }
}
