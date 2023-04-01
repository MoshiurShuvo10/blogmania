package com.rmslab.blogmania.services;

import com.rmslab.blogmania.dtos.CategoryDto;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Service
public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDto) throws NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException;
    CategoryDto updateCategory(CategoryDto categoryDto, int categoryId) ;
    List<CategoryDto> getAllCategories() ;
    CategoryDto getCategoryById(int categoryId) ;
    void deleteCategory(int categoryId) ;
}
