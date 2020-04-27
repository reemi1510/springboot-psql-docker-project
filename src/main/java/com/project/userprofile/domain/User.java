package com.project.userprofile.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "user_profile")
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    private long id;

    @Column(name = "email_address")
    @Size(max = 255)
    private String email;

    @Column(name = "first_name")
    @Size(max = 255)
    private String firstName;

    @Column(name = "last_name")
    @Size(max = 255)
    private String lastName;

    @Column(name = "created")
    @CreationTimestamp
    private LocalDateTime created;

    @Column(name = "last_updated")
    @UpdateTimestamp
    private LocalDateTime lastUpdated;

    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(mappedBy = "user")
    private List<Appointment> appointments = new ArrayList<>();

    public User(String email, String firstName, String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
