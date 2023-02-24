package com.CS304Project.Project.Controller;

import com.CS304Project.Project.DTO.FeedbackDTO;
import com.CS304Project.Project.Service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@CrossOrigin
@RequestMapping
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;
    @GetMapping("/getAllFeedback")
    public ResponseEntity<?> getAllFeedback(){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        List<FeedbackDTO> feedbackDTOS = feedbackService.getAllFeedback();

        if(!feedbackDTOS.isEmpty()){
            map.put("status", 1);
            map.put("data", feedbackDTOS);
            return new ResponseEntity<>(map, HttpStatus.OK);

        }else{
            map.clear();
            map.put("status", 0);
            map.put("message", "feedback not found");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }
    @PostMapping("/addFeedback")
    public ResponseEntity<?> addFeedback(@RequestBody FeedbackDTO feedbackDTO) throws NoSuchAlgorithmException{
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        FeedbackDTO feedback = feedbackService.addFeedback(feedbackDTO);

        if(feedback != null){
            map.put("status", 1);
            map.put("data", feedback);
            return new ResponseEntity<>(map, HttpStatus.OK);

        }else{
            map.clear();
            map.put("status", 0);
            map.put("message", "Feedback not added");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }
    @PutMapping("/updateFeedback")
    public ResponseEntity<?> updateFeedback(FeedbackDTO feedbackDTO){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        FeedbackDTO feedback = feedbackService.updateFeedback(feedbackDTO);

        if(feedback != null){
            map.put("status", 1);
            map.put("data", feedback);
            return new ResponseEntity<>(map, HttpStatus.OK);

        }else{
            map.clear();
            map.put("status", 0);
            map.put("message", "Feedback not found");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }
    @GetMapping("/getFeedbackById/{feedbackId}")
    public ResponseEntity<?> getFeedbackById(@PathVariable int feedbackId){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        FeedbackDTO feedbackDTO = feedbackService.getFeedbackById(feedbackId);

        if(feedbackDTO != null){
            map.put("status", 1);
            map.put("data", feedbackDTO);
            return  new ResponseEntity<>(map, HttpStatus.OK);

        }else{
            map.clear();
            map.put("status", 0);
            map.put("message", "Feedback not found");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }
    @DeleteMapping("/deleteFeedback/{feedbackId}")
    public ResponseEntity<?> deleteFeedback(@PathVariable int feedbackId){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        boolean deleted = feedbackService.deleteFeedback(feedbackId);

        if(deleted){
            map.put("status", 1);
            map.put("data", deleted);
            return new ResponseEntity<>(map, HttpStatus.OK);

        }else{
            map.clear();
            map.put("status", 0);
            map.put("message", "Feedback not found");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }
}
