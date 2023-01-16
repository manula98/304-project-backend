package com.CS304Project.Project.Service;

import com.CS304Project.Project.DTO.LoginUserDetailsDTO;
import com.CS304Project.Project.DTO.UserFullDTO;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface LoginUserDetailsService {
    LoginUserDetailsDTO addLoginDetails(UserFullDTO userFullDTO) throws NoSuchAlgorithmException;
    LoginUserDetailsDTO updatePassword(LoginUserDetailsDTO loginUserDetailsDTO) throws NoSuchAlgorithmException;
    List<LoginUserDetailsDTO> getAllLoginUserDetails();

    boolean validateEmail(String email);
}
