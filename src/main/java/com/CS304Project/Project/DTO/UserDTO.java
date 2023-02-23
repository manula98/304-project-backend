package com.CS304Project.Project.DTO;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {
    private int userId;
    private String fname;
    private String lname;
    private int loginId;
    private int isAdmin;
}
