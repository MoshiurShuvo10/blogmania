package com.rmslab.blogmania.services;

import com.rmslab.blogmania.dtos.CategoryDto;
import com.rmslab.blogmania.entities.Category;
import com.rmslab.blogmania.exceptions.ResourceNotFoundException;
import com.rmslab.blogmania.repositories.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryRepository categoryRepository ;

    @Autowired
    ModelMapper modelMapper ;

    private CategoryDto categoryToDto(Category category) {
        CategoryDto categoryDto = modelMapper.map(category, CategoryDto.class) ;
        return categoryDto ;
    }

    private Category dtoToCategory(CategoryDto categoryDto) {
        Category category = modelMapper.map(categoryDto, Category.class) ;
        return category ;
    }

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = categoryRepository.save(dtoToCategory(categoryDto)) ;
        return categoryToDto(category) ;
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, int categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("category", "id", categoryId)); ;
        category.setTitle(categoryDto.getTitle());
        category.setDescription(categoryDto.getDescription());
        return categoryToDto(categoryRepository.save(category)) ;
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll().stream().map(category -> categoryToDto(category)).collect(Collectors.toList());
    }

    @Override
    public CategoryDto getCategoryById(int categoryId) {
       Category category = categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("category","Id",categoryId)) ;
       return categoryToDto(category) ;
    }

    @Override
    public void deleteCategory(int categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(()-> new ResourceNotFoundException("category","Id",categoryId)) ;
        categoryRepository.delete(category);
    }
}
