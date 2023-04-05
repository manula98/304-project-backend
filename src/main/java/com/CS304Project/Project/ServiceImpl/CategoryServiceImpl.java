package com.CS304Project.Project.ServiceImpl;

import com.CS304Project.Project.DTO.CategoryDTO;
import com.CS304Project.Project.Entity.Category;
import com.CS304Project.Project.Repository.CategoryRepository;
import com.CS304Project.Project.Service.CategoryService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CategoryDTO> getAllCategory() {
        try{
            List<Category> categories = categoryRepository.findAll();

            if(categories == null){
                return null;
            }else{
                return modelMapper.map(categories, new TypeToken<List<CategoryDTO>>(){}.getType());
            }
        }catch (Exception e){
            System.out.println(e.toString());
            return null;
        }
    }

    @Override
    public CategoryDTO addCategory(CategoryDTO categoryDTO) throws NoSuchAlgorithmException {
        try{
            Category category = modelMapper.map(categoryDTO, Category.class);
            Category addCategory = categoryRepository.save(category);

            return modelMapper.map(addCategory, new TypeToken<CategoryDTO>(){}.getType());
        }catch (Exception e){
            System.out.println(e.toString());
            return null;
        }
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO) {
        try{
            CategoryDTO validCategory = getCategoryById(categoryDTO.getCategoryId());

            if(validCategory != null){
                Category category = categoryRepository.updateCategory(categoryDTO.getCategoryName(), categoryDTO.getCategoryId());

                return modelMapper.map(category, new TypeToken<CategoryDTO>(){}.getType());
            }
            return null;
        }catch (Exception e){
            System.out.println(e.toString());
            return null;
        }
    }

    @Override
    public CategoryDTO getCategoryById(int categoryId) {
        try{
            Category category = categoryRepository.getCategoryById(categoryId);

            if(category != null){
                return modelMapper.map(category, new TypeToken<CategoryDTO>(){}.getType());
            }
            return null;
        }catch (Exception e){
            System.out.println(e.toString());
            return null;
        }
    }

    @Override
    public boolean deleteCategory(int categoryId) {
        boolean delete = false;
        try{
            CategoryDTO categoryDTO = getCategoryById(categoryId);

            if(categoryDTO != null){
                categoryRepository.deleteById(categoryId);
                delete = true;
            }
            return delete;
        }catch (Exception e){
            System.out.println(e.toString());
            return delete;
        }
    }
}
