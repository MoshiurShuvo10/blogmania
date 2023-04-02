package com.rmslab.blogmania.controllers;

import com.rmslab.blogmania.dtos.ApiResponseDto;
import com.rmslab.blogmania.dtos.CategoryDto;
import com.rmslab.blogmania.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService ;

    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto) {
        CategoryDto createdCategoryDto = categoryService.createCategory(categoryDto) ;
        return new ResponseEntity<>(createdCategoryDto, HttpStatus.CREATED) ;
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable int categoryId) {
        CategoryDto updatedCategory = categoryService.updateCategory(categoryDto, categoryId) ;
        return ResponseEntity.ok(updatedCategory) ;
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<?> deleteCategory(@PathVariable int categoryId) {
        categoryService.deleteCategory(categoryId);
        return new ResponseEntity(new ApiResponseDto("Category Deleted Successfully", true), HttpStatus.OK) ;
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getAllCategory() {
        return ResponseEntity.ok(categoryService.getAllCategories()) ;
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable int categoryId) {
        CategoryDto categoryDto = categoryService.getCategoryById(categoryId) ;
        return ResponseEntity.ok(categoryDto) ;
    }
}
