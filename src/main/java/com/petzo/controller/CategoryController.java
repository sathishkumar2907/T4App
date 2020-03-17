package com.petzo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.annotations.GeneratorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.petzo.DAO.CategoryDAO;
import com.petzo.DAO.CheeseDAO;
import com.petzo.DTO.Category;

@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	CheeseDAO cheeseDAO;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@GetMapping(value="/")
	@ResponseBody
	public List<Category> display(){
		return categoryDAO.findAll();
	}
}
