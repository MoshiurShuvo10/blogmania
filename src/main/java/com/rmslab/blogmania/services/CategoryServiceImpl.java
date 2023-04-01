package com.rmslab.blogmania.services;

import com.rmslab.blogmania.dtos.CategoryDto;
import com.rmslab.blogmania.entities.Category;
import com.rmslab.blogmania.repositories.CategoryRepository;
import com.rmslab.blogmania.utils.ModelMapperUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryRepository categoryRepository ;

    @Autowired
    ModelMapper modelMapper ;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category ;
        CategoryDto createdCategory ;
        try{
            category = ModelMapperUtil.dtoToModelConverter(categoryDto, Category.class) ;
            createdCategory = ModelMapperUtil.modelToDtoConverter(categoryRepository.save(category), CategoryDto.class) ;
        } catch (Exception e) {
            throw new RuntimeException("Failed to create category ", e) ;
        }
        return  createdCategory ;
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, int categoryId) {
        return null;
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        return null;
    }

    @Override
    public CategoryDto getCategoryById(int categoryId) {
        return null;
    }

    @Override
    public void deleteCategory(int categoryId) {

    }
}
