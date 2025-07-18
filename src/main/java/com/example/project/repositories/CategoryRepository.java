package com.example.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

	void deleteById(Long categoryId);	
}
