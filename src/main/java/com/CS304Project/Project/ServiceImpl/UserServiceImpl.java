package com.CS304Project.Project.ServiceImpl;

import com.CS304Project.Project.DTO.LoginUserDetailsDTO;
import com.CS304Project.Project.DTO.UserDTO;
import com.CS304Project.Project.DTO.UserFullDTO;
import com.CS304Project.Project.Entity.LoginUserDetails;
import com.CS304Project.Project.Entity.User;
import com.CS304Project.Project.Repository.UserRepository;
import com.CS304Project.Project.Service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LoginUserDetailsImpl loginUserDetailsImpl;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<UserDTO> getAllUsers() {
       try{
           List<User> userList = userRepository.findAll();
           return modelMapper.map(userList, new TypeToken<List<UserDTO>>(){
           }.getType());
       }
       catch(Exception e){
           System.out.println(e.toString());
           return null;
        }
    }


    @Override
    public UserDTO addUser(UserFullDTO userFullDTO) throws NoSuchAlgorithmException {
        try{
            boolean valid = loginUserDetailsImpl.validateEmail(userFullDTO.getEmail());

            if(valid){
                LoginUserDetailsDTO luddto = loginUserDetailsImpl.addLoginUserDetails(userFullDTO);
                //System.out.println(luddto.getEmail());
                LoginUserDetails lud = modelMapper.map(luddto, LoginUserDetails.class);

                User u = modelMapper.map(userFullDTO, User.class);
                u.setLoginUserDetails(lud);
                User us = userRepository.save(u);

                return modelMapper.map(us, new TypeToken<UserDTO>(){
                }.getType());
                
            }else{
                return null;
            }

        } catch(Exception e){
            return null;
        }
    }

    @Override
    public UserDTO getUserById(int userId) {
        try{
            User user = userRepository.getUserById(userId);

            if(user == null){
                return null;

            }else{
                return modelMapper.map(user, new TypeToken<UserDTO>(){
                }.getType());
            }

        }catch(Exception e){
            System.out.println(e.toString());
            return null;
        }
    }

    @Override
    public UserDTO updateUser(UserFullDTO userFullDTO) {
        try{
            UserDTO validUser = getUserById(userFullDTO.getUserId());

            if(validUser != null){
                User user = userRepository.updateUser(userFullDTO.getFname(),userFullDTO.getLname(),userFullDTO.getUserId());
                return modelMapper.map(user, new TypeToken<UserDTO>(){
                }.getType());

            }else{
                return null;
            }

        }catch(Exception e){
            System.out.println(e.toString());
            return null;
        }
    }

    @Override
    public boolean deleteUser(int userId) {
        boolean delete = false;
        try{
            UserDTO user = getUserById(userId);

            if(user != null){
                userRepository.deleteById(user.getUserId());
                delete = true;
            }
            return delete;

        }catch(Exception e){
            System.out.println(e.toString());
            return delete;
        }
    }
}
