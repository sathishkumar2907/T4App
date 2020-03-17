package com.petzo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petzo.DAO.CategoryDAO;
import com.petzo.DAO.CheeseDAO;
import com.petzo.DTO.Category;
import com.petzo.DTO.CheeseDTO;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CheeseDAO cheeseDAO;
	
	@Autowired
	CategoryDAO categoryDAO;

	@Override
	public Category findById(long id) {
		
		Category category=null;
		
		try {
			
			category=categoryDAO.findbyId(id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return category;
	}
}
