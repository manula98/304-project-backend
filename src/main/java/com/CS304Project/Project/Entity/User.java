package com.CS304Project.Project.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.LifecycleState;

import java.util.List;

@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="userId")
    private int userId;

    @Column(name="fname")
    private String fname;

    @Column(name="lname")
    private String lname;

    @Column(name="isAdmin")
    private  int isAdmin;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "loginId", referencedColumnName = "loginId")
    private LoginUserDetails loginUserDetails;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Reservation> reservations;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Feedback> feedbacks;
}
