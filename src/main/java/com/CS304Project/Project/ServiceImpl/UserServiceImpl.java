package com.CS304Project.Project.ServiceImpl;

import com.CS304Project.Project.DTO.UserDTO;
import com.CS304Project.Project.DTO.UserFullDTO;
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
//            boolean valid = l;
            return null;
        }
        catch(Exception e){
            return null;
        }
    }

    @Override
    public UserDTO getUserById(int userId) {
        return null;
    }

    @Override
    public UserDTO updateUser(UserFullDTO userFullDTO) {
        return null;
    }

    @Override
    public boolean deleteUser(int userId) {
        return false;
    }
}
