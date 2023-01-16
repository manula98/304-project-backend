package com.CS304Project.Project.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserFullDTO {
    private int userId;
    private String fname;
    private String lname;
    private String email;
    private String password;
    private int loginId;
    private int isAdmin;

}
