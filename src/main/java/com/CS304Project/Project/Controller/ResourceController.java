package com.CS304Project.Project.Controller;

import com.CS304Project.Project.DTO.ResorceDTO;
import com.CS304Project.Project.Service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @GetMapping("/getAllResources")
    public ResponseEntity<?> getAllResource(){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        List<ResorceDTO> resourceList = resourceService.getAllResources();

        if(!resourceList.isEmpty()){
            map.put("status", 1);
            map.put("data", resourceList);
            return new ResponseEntity<>(map, HttpStatus.OK);
        }else{
            map.clear();
            map.put("status", 0);
            map.put("message","Resource not found");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addResource")
    public ResponseEntity<?> addResource(@RequestBody ResorceDTO resorceDTO) throws NoSuchAlgorithmException{
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        ResorceDTO resource = resourceService.addResource(resorceDTO);

        if(resource != null){
            map.put("status", 1);
            map.put("data", resource);
            return new ResponseEntity<>(map, HttpStatus.OK);

        }else{
            map.clear();
            map.put("status", 0);
            map.put("message", "Resource not added");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getresourcebyid/{resourceId}")
    public ResponseEntity<?> getResourceById(@PathVariable int resourceId){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        ResorceDTO resource = resourceService.getResourceById(resourceId);

        if(resource != null){
            map.put("status", 1);
            map.put("data", resource);
            return new ResponseEntity<>(map, HttpStatus.OK);

        }else{
            map.clear();
            map.put("status", 0);
            map.put("message", "Resource not found");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }

    }
    @PutMapping("/updateResource")
    public ResponseEntity<?> updateResource(@RequestBody ResorceDTO resorceDTO){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        ResorceDTO resource = resourceService.updateResource(resorceDTO);

        if(resource != null){
            map.put("status",1);
            map.put("data",resource);
            return new ResponseEntity<>(map, HttpStatus.OK);

        }else{
            map.clear();
            map.put("status",0);
            map.put("message","Resource not found");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/deleteResourc/{resourceId}")
    public ResponseEntity<?> deleteResource(@PathVariable int resourceId){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        boolean deleted = resourceService.deleteResource(resourceId);

        if(deleted){
            map.put("status", 1);
            map.put("data", deleted);
            return new ResponseEntity<>(map, HttpStatus.OK);

        }else{
            map.clear();
            map.put("status", 0);
            map.put("message", "Resource not found");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
    }
}
