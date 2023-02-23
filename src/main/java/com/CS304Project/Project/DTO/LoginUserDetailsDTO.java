package com.CS304Project.Project.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LoginUserDetailsDTO {
    private int loginId;
    private String email;
    private String password;
    public LoginUserDetailsDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
