package com.CS304Project.Project.Controller;

import com.CS304Project.Project.DTO.AdministrativeDTO;
import com.CS304Project.Project.Service.AdministrativeService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@CrossOrigin
@RequestMapping
public class AdministrativeController {

    @Autowired
    private AdministrativeService administrativeService;
    @GetMapping("/getAllAdministrative")
    public ResponseEntity<?> getAllAdministrative(){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        List<AdministrativeDTO> administrativeDTOS = administrativeService.getAllAdministrative();

        if(!administrativeDTOS.isEmpty()){
            map.put("status", 1);
            map.put("data", administrativeDTOS);
            return new ResponseEntity<>(map, HttpStatus.OK);

        }else{
            map.clear();
            map.put("status", 0);
            map.put("message", "Administrative not found");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }
    @PostMapping("/addAdministrative")
    public ResponseEntity<?> addAdministrative(@RequestBody AdministrativeDTO administrativeDTO) throws NoSuchAlgorithmException{
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        AdministrativeDTO administrative = administrativeService.addAdministrative(administrativeDTO);

        if(administrative != null){
            map.put("status", 1);
            map.put("data", administrative);
            return new ResponseEntity<>(map, HttpStatus.OK);

        }else{
            map.clear();
            map.put("status", 0);
            map.put("message", "Administrative not added");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }
    @PutMapping("/updateAdministrative")
    public ResponseEntity<?> updateAdministrative(AdministrativeDTO administrativeDTO){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        AdministrativeDTO administrative = administrativeService.updateAdministrative(administrativeDTO);

        if(administrative != null){
            map.put("status", 1);
            map.put("data", administrative);
            return new ResponseEntity<>(map, HttpStatus.OK);

        }else{
            map.clear();
            map.put("status", 0);
            map.put("message", "Administrative not found");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }
    @GetMapping("/getAdministrativeById/{adminId}")
    public ResponseEntity<?> getAdministrativeById(@PathVariable int adminId){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        AdministrativeDTO administrativeDTO = administrativeService.getAdministrativeById(adminId);

        if(administrativeDTO != null){
            map.put("status", 1);
            map.put("data", administrativeDTO);
            return new ResponseEntity<>(map, HttpStatus.OK);

        }else{
            map.clear();
            map.put("status", 0);
            map.put("message", "Administrative not found");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }
    @DeleteMapping("/deleteAdministrative/{adminId}")
    public ResponseEntity<?> deleteAdministrative(@PathVariable int adminId){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        boolean deleted = administrativeService.deleteAdministrative(adminId);

        if(deleted){
            map.put("status", 1);
            map.put("data", deleted);
            return new ResponseEntity<>(map, HttpStatus.OK);

        }else{
            map.clear();
            map.put("status", 0);
            map.put("message", "Administrative not found");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }
}
