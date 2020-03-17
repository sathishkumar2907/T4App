package com.petzo.controller;

import java.util.List;

import org.hibernate.annotations.GeneratorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.petzo.DAO.CategoryDAO;
import com.petzo.DAO.CheeseDAO;
import com.petzo.DTO.CheeseDTO;
import com.petzo.services.CategoryService;

@Controller
@RequestMapping("/")
public class CheeseController {
	
	@Autowired
	CheeseDAO cheeseDAO;
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/")
	@ResponseBody
	public List<CheeseDTO> dispaly(){
		return cheeseDAO.findAll();
	}

	
	@PostMapping("/save")
	@ResponseBody
	public void save(@RequestBody CheeseDTO cheeseDTO){
		cheeseDTO.setCategory(categoryService.findById(cheeseDTO.getCategory_mentor_id()));
		cheeseDAO.save(cheeseDTO);
	}
	
}
