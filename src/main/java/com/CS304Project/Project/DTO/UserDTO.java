package com.CS304Project.Project.DTO;

import com.CS304Project.Project.Entity.Role;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {
    private int userId;
    private String fname;
    private String lname;
    private String email;
    private int loginId;
    private Role role;
    private String telephone;
    private String userRole;
}
