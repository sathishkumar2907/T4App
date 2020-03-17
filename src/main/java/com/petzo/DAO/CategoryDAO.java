package com.petzo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petzo.DTO.Category;

public interface CategoryDAO extends JpaRepository<Category, Long>{
  
	Category findbyId(long id);
}
