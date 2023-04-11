package com.CS304Project.Project.ServiceImpl;

import com.CS304Project.Project.DTO.LoginUserDetailsDTO;
import com.CS304Project.Project.DTO.UserFullDTO;
import com.CS304Project.Project.Entity.LoginUserDetails;
import com.CS304Project.Project.Repository.LoginUserDetailsRepository;
import com.CS304Project.Project.Service.LoginUserDetailsService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class LoginUserDetailsImpl implements LoginUserDetailsService {
    @Autowired
    private LoginUserDetailsRepository loginUserDetailsRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean validateEmail(String email) {
        boolean valid = false;
        try {
            LoginUserDetails loginUserDetails = loginUserDetailsRepository.validateEmail(email);
            if (loginUserDetails == null) {
                valid = true;
            } else {
                valid = false;
            }
            return valid;
        } catch (Exception e) {
            System.out.println(e.toString());
            return valid;
        }
    }

    public LoginUserDetailsDTO addLoginUserDetails(UserFullDTO userFullDTO) throws NoSuchAlgorithmException {
        try {
            System.out.println(userFullDTO.getPassword());
//            LoginUserDetailsDTO luddto = new LoginUserDetailsDTO(userFullDTO.getEmail(), userFullDTO.getPassword());

            LoginUserDetails newLogin=new LoginUserDetails();

            String enPassword = passwordEncoder.encode(userFullDTO.getPassword());
            System.out.println(enPassword);
            newLogin.setEmail(userFullDTO.getEmail());
            newLogin.setPassword(enPassword);

            LoginUserDetails lud = loginUserDetailsRepository.save(newLogin);
            return modelMapper.map(lud, new TypeToken<LoginUserDetailsDTO>() {
            }.getType());
        }
        catch(Exception e)
            {
                System.out.println(e.toString());
                return null;
            }
        }

    public LoginUserDetailsDTO getLoginUserDetailsById(int loginId){
        try{
            LoginUserDetails loginUserDetails = loginUserDetailsRepository.getLoginUserDetailsById(loginId);

            if(loginUserDetails == null){
                return null;
            }
            return modelMapper.map(loginUserDetails, new TypeToken<LoginUserDetailsDTO>(){
            }.getType());

        }catch(Exception e){
            System.out.println(e.toString());
        }
        return null;
    }

    @Override
    public LoginUserDetailsDTO updatePassword(LoginUserDetailsDTO userDetailsDTO) throws NoSuchAlgorithmException{
        try{
            LoginUserDetailsDTO loignuddto = getLoginUserDetailsById(userDetailsDTO.getLoginId());

            if(loignuddto != null){
                String enPassword = passwordEncoder.encode(userDetailsDTO.getPassword());
                loginUserDetailsRepository.updateLoginPassword(enPassword,userDetailsDTO.getLoginId());
                return getLoginUserDetailsById(userDetailsDTO.getLoginId());
            }
        }catch(Exception e){
            System.out.println(e.toString());
        }
        return null;
    }

    @Override
    public List<LoginUserDetailsDTO> getAllLoginUserDetails() {
        try{
            List<LoginUserDetails> loginUserDetailsList = loginUserDetailsRepository.findAll();
            return modelMapper.map(loginUserDetailsList, new TypeToken<LoginUserDetailsDTO>(){
            }.getType());

        }catch(Exception e){
            System.out.println(e.toString());
            return null;
        }
    }

    @Override
    public LoginUserDetailsDTO getEmailByLoginId(int loginId) {
        try{
//            System.out.println("1");
            LoginUserDetails user = loginUserDetailsRepository.getEmailByLoginId(loginId);
            if(user!=null){
//                System.out.println("2");
                return modelMapper.map(user, new TypeToken<LoginUserDetailsDTO>() {
                }.getType());
            }
//            System.out.println("3");
            return null;
        }
        catch(Exception e){
            System.out.println(e.toString());
            return null;
        }
    }


}
