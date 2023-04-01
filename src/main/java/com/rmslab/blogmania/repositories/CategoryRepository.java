package com.rmslab.blogmania.repositories;

import com.rmslab.blogmania.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
