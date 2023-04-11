package com.CS304Project.Project.Service;

import com.CS304Project.Project.DTO.UserDTO;
import com.CS304Project.Project.DTO.UserFullDTO;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsers();
    UserDTO addUser(UserFullDTO userFullDTO) throws NoSuchAlgorithmException;
    UserDTO getUserById(int userId);
    UserDTO updateUser(UserFullDTO userFullDTO);
    boolean deleteUser(int userId);
    int changeRole(int userId);
}

