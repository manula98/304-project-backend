package com.CS304Project.Project.Controller;

import com.CS304Project.Project.DTO.MultimediaDTO;
import com.CS304Project.Project.Entity.Multimedia;
import com.CS304Project.Project.Service.MultimediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping
public class MultimediaController {
    @Autowired
    private MultimediaService multimediaService;
    @GetMapping("/getAllMutlimedia")
    public ResponseEntity<?> getAllMultimedia(){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        List<MultimediaDTO> multimediaDTOList = multimediaService.getAllMultimedia();

        if(!multimediaDTOList.isEmpty()){
            map.put("status", 1);
            map.put("data",multimediaDTOList);
            return new ResponseEntity<>(map, HttpStatus.OK);

        }else{
            map.clear();
            map.put("status", 0);
            map.put("message", "Multimedia not found");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }
    @PostMapping("/addMultimedia")
    public ResponseEntity<?> addMultimedia(@RequestBody MultimediaDTO multimediaDTO) throws NoSuchAlgorithmException {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        MultimediaDTO multimedia = multimediaService.addMultimedia(multimediaDTO);

        if(multimedia != null){
            map.put("status", 1);
            map.put("data", multimedia);
            return new ResponseEntity<>(map, HttpStatus.OK);

        }else{
            map.clear();
            map.put("status", 0);
            map.put("message", "Multimedia not added");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }
    @PutMapping("/updateMultimedia")
    public ResponseEntity<?> updateMultimedia(@RequestBody MultimediaDTO multimediaDTO){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        MultimediaDTO multimedia = multimediaService.updateMultimedia(multimediaDTO);

        if(multimedia != null){
            map.put("status", 1);
            map.put("data", multimedia);
            return new ResponseEntity<>(map, HttpStatus.OK);

        }else{
            map.clear();
            map.put("status", 0);
            map.put("message", "Multimedia not updated");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }
    @GetMapping("/getMultimediaById/{multimediaId}")
    public ResponseEntity<?> getMultimediaById(@PathVariable int multimediaId){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        MultimediaDTO multimediaDTO = multimediaService.getMultimediaById(multimediaId);

        if(multimediaDTO != null){
            map.put("status", 1);
            map.put("data", multimediaDTO);
            return new ResponseEntity<>(map, HttpStatus.OK);

        }else{
            map.clear();
            map.put("status", 0);
            map.put("message", "Multimedia not found");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }
    @DeleteMapping("/deleteMultimedia/{multimediaId}")
    public ResponseEntity<?> deleteMultimedia(@PathVariable int multimediaId){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        boolean deleted = multimediaService.deleteMultimedia(multimediaId);

        if(deleted){
            map.put("status", 1);
            map.put("data", deleted);
            return new ResponseEntity<>(map, HttpStatus.OK);

        }else{
            map.clear();
            map.put("status", 0);
            map.put("message", "Multimedia not found");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }
}
