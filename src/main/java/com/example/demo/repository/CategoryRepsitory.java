package com.example.demo.repository;

import com.example.demo.domain.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepsitory extends JpaRepository<Category,Long>{
    
}
