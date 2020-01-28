package com.isa.domain.entity;

import javax.persistence.*;
import java.util.List;

@NamedQueries({
        @NamedQuery(
                name = "User.findAll",
                query = "SELECT u FROM User u"
        ),
        @NamedQuery(
                name = "User.findByEmail",
                query = "SELECT u FROM User u WHERE u.email = :email"
        ),
        @NamedQuery(
                name = "User.findWithFavouriteEvents",
                query = "SELECT u FROM User u INNER JOIN u.favoriteEvents e WHERE e.id = :id"
        )
})

@Entity
@Table (name = "user")
public class User {

    @Id
    @Column (name = "id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "email")
    private String email;

    @Column (name = "google_id")
    private String googleId;


    @Column (name = "user_type")
    private UserType userType;

    @ManyToMany (fetch = FetchType.LAZY)
    @JoinTable (name = "user_event",
            joinColumns = @JoinColumn (name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn (name = "event_id", referencedColumnName = "id"))
    private List<Event> favoriteEvents;

    @Column (name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public String getGoogleId() {
        return googleId;
    }

    public void setGoogleId(String googleId) {
        this.googleId = googleId;
    }
}
