package com.petzo.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petzo.DTO.CourseDTO;

public interface CourseDAO extends JpaRepository<CourseDTO, Long>{

	CourseDTO findByFullname(String fullname);
	CourseDTO findById(long id);
	List<CourseDTO> findByFullnameOrSubject(String fullname, String subject);
}
