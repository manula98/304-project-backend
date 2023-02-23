package com.CS304Project.Project.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "LoginUserDetails")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LoginUserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="loginId")
    private int loginId;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @OneToOne(mappedBy = "loginUserDetails")
    private User user;

}
