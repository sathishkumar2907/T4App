package com.petzo.services;

import java.util.List;

import com.petzo.DTO.CourseDTO;

public interface CourseService {
	
	void saveCourse(CourseDTO courseDTO);
	List<CourseDTO> getAllCourses();
	CourseDTO findById(long id);
	CourseDTO findByFullname(String fullname);
	CourseDTO updateCourse(CourseDTO courseDTO,Long id);
	List<CourseDTO> findByFullname(String fullname, String subject);
	CourseDTO updateCourses(CourseDTO courseDTO, long id);
}
