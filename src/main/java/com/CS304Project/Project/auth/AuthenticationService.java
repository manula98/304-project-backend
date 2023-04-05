package com.CS304Project.Project.auth;

import com.CS304Project.Project.DTO.UserDTO;
import com.CS304Project.Project.DTO.UserFullDTO;
import com.CS304Project.Project.Entity.LoginUserDetails;
import com.CS304Project.Project.Repository.LoginUserDetailsRepository;
import com.CS304Project.Project.ServiceImpl.UserServiceImpl;
import com.CS304Project.Project.config.JwtService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    @Autowired
    private final LoginUserDetailsRepository repo;
    @Autowired
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private final JwtService jwtService;
    @Autowired
    private final AuthenticationManager authenticationManager;

    @Autowired
    private final UserServiceImpl userServiceImpl;
    @Autowired
    private ModelMapper modelMapper;

    public AuthenticationResponse register(UserFullDTO userdata) throws NoSuchAlgorithmException {
        UserDTO userDTO = userServiceImpl.addUser(userdata);
        if(userDTO !=null){
            var user = modelMapper.map(userdata, LoginUserDetails.class);
            //UserDTO newUser=userServiceImpl.getUserById(userDTO.getUserId());
            var jwtToken = jwtService.generateToken(user);
            //System.out.println(jwtToken);
            return  AuthenticationResponse.builder()
                    .token(jwtToken)
                    .user(userDTO)
                    .build();
        }
        return null;

    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        try{

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );

            var user = repo.findByEmail(request.getEmail())
                    .orElseThrow();
            System.out.println(user.getUsername());
            if(user!=null){
                var jwtToken = jwtService.generateToken(user);
                return AuthenticationResponse.builder()
                        .token(jwtToken)
                        .user(modelMapper.map(user.getUser(), new TypeToken<UserDTO>() {}.getType()))
                        .build();
            }
            else{
                return null;
            }
        }catch(Exception e){
            System.out.println(e.toString());
            return null;
        }
    }

}