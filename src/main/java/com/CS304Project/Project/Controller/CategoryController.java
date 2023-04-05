package com.CS304Project.Project.Controller;

import com.CS304Project.Project.DTO.CategoryDTO;
import com.CS304Project.Project.Service.CategoryService;
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
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @GetMapping("/getAllCategory")
    public ResponseEntity<?> getAllCategory(){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        List<CategoryDTO> categoryDTOS = categoryService.getAllCategory();
        map.put("status", 1);
        map.put("data", "categoryDTOS");
        return new ResponseEntity<>(map, HttpStatus.OK);

//        if(!categoryDTOS.isEmpty()){
//            map.put("status", 1);
//            map.put("data", categoryDTOS);
//            return new ResponseEntity<>(map, HttpStatus.OK);
//
//        }else{
//            map.clear();
//            map.put("status", 0);
//            map.put("message", "Category not found");
//            return new ResponseEntity<>(map, HttpStatus.OK);
//        }
    }
    @PostMapping("/addCategory")
    public ResponseEntity<?> addCategory(@RequestBody CategoryDTO categoryDTO) throws NoSuchAlgorithmException {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        CategoryDTO addCategoryDTO = categoryService.addCategory(categoryDTO);

        if(addCategoryDTO != null){
            map.put("status", 1);
            map.put("data", addCategoryDTO);
            return new ResponseEntity<>(map, HttpStatus.OK);

        }else{
            map.clear();
            map.put("status", 0);
            map.put("message", "Category not added");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }
    @PutMapping("/updateCategory")
    public ResponseEntity<?> updateCategory(CategoryDTO categoryDTO) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        CategoryDTO updateCategoryDTO = categoryService.updateCategory(categoryDTO);

        if(updateCategoryDTO != null){
            map.put("status", 1);
            map.put("data", updateCategoryDTO);
            return new ResponseEntity<>(map, HttpStatus.OK);

        }else{
            map.clear();
            map.put("status", 0);
            map.put("message", "Category not found");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }
    @GetMapping("/getCategoryById/{categoryId}")
    public ResponseEntity<?> getCategoryById(@PathVariable int categoryId) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        CategoryDTO category = categoryService.getCategoryById(categoryId);

        if(category != null){
            map.put("status", 1);
            map.put("data", category);
            return new ResponseEntity<>(map, HttpStatus.OK);

        }else{
            map.clear();
            map.put("status", 0);
            map.put("message", "Category not found");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }
    @DeleteMapping("/deleteCategory/{categoryId}")
    public ResponseEntity<?> deleteCategory(@PathVariable int categoryId) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        boolean deleted = categoryService.deleteCategory(categoryId);

        if(deleted){
            map.put("status", 1);
            map.put("data", deleted);
            return new ResponseEntity<>(map, HttpStatus.OK);

        }else{
            map.clear();
            map.put("status", 0);
            map.put("message", "Category not found");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }
}
