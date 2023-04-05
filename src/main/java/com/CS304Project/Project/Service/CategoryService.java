package com.CS304Project.Project.Service;

import com.CS304Project.Project.DTO.CategoryDTO;
import com.CS304Project.Project.Entity.Category;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface CategoryService {

    List<CategoryDTO> getAllCategory();
    CategoryDTO addCategory(CategoryDTO categoryDTO) throws NoSuchAlgorithmException;
    CategoryDTO updateCategory(CategoryDTO categoryDTO);
    CategoryDTO getCategoryById(int categoryId);
    boolean deleteCategory(int categoryId);
}
