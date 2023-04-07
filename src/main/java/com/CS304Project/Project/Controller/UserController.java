package com.CS304Project.Project.Controller;

import com.CS304Project.Project.DTO.UserDTO;
import com.CS304Project.Project.DTO.UserFullDTO;
import com.CS304Project.Project.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getallusers")
    public ResponseEntity<?> getAllUsers(){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        List<UserDTO> userList= userService.getAllUsers();
        if (userList!=null) {
            map.put("status", 1);
            map.put("data", userList);
            return new ResponseEntity<>(map, HttpStatus.OK);
        } else {
            map.clear();
            map.put("status", 0);
            map.put("message", "User list is not found");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }

    @PostMapping("/addUser")
    public ResponseEntity<?>  addUser(@RequestBody UserFullDTO userFullDTO) throws NoSuchAlgorithmException {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        UserDTO user = userService.addUser(userFullDTO);
        //String user = userService.addUser(userdata);
        if (user != null) {
            map.put("status", 1);
            map.put("data", user);
            return new ResponseEntity<>(map, HttpStatus.OK);
        } else {
            map.clear();
            map.put("status", 0);
            map.put("message", "User not added");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }

    @GetMapping("/getuserbyid/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable int userId){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        UserDTO user = userService.getUserById(userId);
        if(user != null){
            map.put("status", 1);
            map.put("data", user);
            return new ResponseEntity<>(map, HttpStatus.OK);

        }else{
            map.clear();
            map.put("status", 0);
            map.put("message", "User not found");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }

    @PutMapping("/updateUser")
    public ResponseEntity<?> updateUser(@RequestBody UserFullDTO userFullDTO){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        UserDTO user = userService.updateUser(userFullDTO);

        if(user != null){
            map.put("status", 1);
            map.put("data", user);
            return new ResponseEntity<>(map, HttpStatus.OK);

        }else{
            map.clear();
            map.put("status", 0);
            map.put("message", "USer not found");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }

    @DeleteMapping("/deleteuser/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable int userId){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        boolean deleted = userService.deleteUser(userId);
        if(deleted){
            map.put("status", 1);
            map.put("data", deleted);
            return new ResponseEntity<>(map, HttpStatus.OK);

        }else{
            map.clear();
            map.put("status", 0);
            map.put("message", "User not found");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }
}
