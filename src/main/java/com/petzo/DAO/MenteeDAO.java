package com.petzo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petzo.DTO.MenteeDTO;

@Repository
public interface MenteeDAO extends JpaRepository<MenteeDTO, Long>{
	
	MenteeDTO findById(long id);

}
