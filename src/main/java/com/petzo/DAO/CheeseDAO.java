package com.petzo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petzo.DTO.CheeseDTO;

public interface CheeseDAO extends JpaRepository<CheeseDTO, Long>{

	CheeseDTO findById(long id);
}
