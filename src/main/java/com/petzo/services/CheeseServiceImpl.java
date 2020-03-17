package com.petzo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petzo.DAO.CategoryDAO;
import com.petzo.DAO.CheeseDAO;

@Service
public class CheeseServiceImpl implements CheeseService{

	@Autowired
	CheeseDAO cheeseDAO;
	
	@Autowired
	CategoryDAO categoryDAO;
	
}
