package com.CS304Project.Project.Controller;

import com.CS304Project.Project.DTO.FacilityDTO;
import com.CS304Project.Project.Service.FacilityService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.*;

@RestController
@CrossOrigin
@RequestMapping
public class FacilityController {

    @Autowired
    private FacilityService facilityService;
    @GetMapping("/getAllFacility")
    public ResponseEntity<?> getAllFacility() {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        List<FacilityDTO> facilityDTOS = facilityService.getAllFacility();

        if (!facilityDTOS.isEmpty()) {
            map.put("status", 1);
            map.put("data", facilityDTOS);
            return new ResponseEntity<>(map, HttpStatus.OK);

        } else {
            map.clear();
            map.put("status", 0);
            map.put("message", "Facilities not found");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }
    @PostMapping("/addFacility")
    public ResponseEntity<?> addFacility(@RequestBody FacilityDTO facilityDTO) throws NoSuchAlgorithmException {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        FacilityDTO facility = facilityService.addFacility(facilityDTO);

        if (facility != null) {
            map.put("status", 1);
            map.put("data", facility);
            return new ResponseEntity<>(map, HttpStatus.OK);

        } else {
            map.clear();
            map.put("status", 0);
            map.put("message", "Facility not added");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }
    @PutMapping("/updateFacility")
    public ResponseEntity<?> updateFacility(FacilityDTO facilityDTO) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        FacilityDTO facility = facilityService.updateFacility(facilityDTO);

        if (facility != null) {
            map.put("status", 1);
            map.put("data", facility);
            return new ResponseEntity<>(map, HttpStatus.OK);

        } else {
            map.clear();
            map.put("status", 0);
            map.put("message", "Facility not found");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }
    @GetMapping("/getFacilityById/{facilityId}")
    public ResponseEntity<?> getFacilityById(@PathVariable int facilityId){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        FacilityDTO facilityDTO = facilityService.getFacilityById(facilityId);

        if(facilityDTO != null){
            map.put("status", 1);
            map.put("data", facilityDTO);
            return new ResponseEntity<>(map, HttpStatus.OK);

        }else{
            map.clear();
            map.put("status", 0);
            map.put("message", "Faciliti not found");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }
    @DeleteMapping("/deleteFacility/{facilityId}")
    public ResponseEntity<?> deleteFacility(@PathVariable int facilityId){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        boolean deleted = facilityService.deleteFacility(facilityId);

        if(deleted){
            map.put("status", 1);
            map.put("data", deleted);
            return new ResponseEntity<>(map, HttpStatus.OK);

        }else{
            map.clear();
            map.put("status", 0);
            map.put("message", "Facility not found");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }
}