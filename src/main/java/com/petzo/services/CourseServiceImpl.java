package com.petzo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petzo.DAO.CourseDAO;
import com.petzo.DAO.MenteeDAO;
import com.petzo.DTO.CourseDTO;
import com.petzo.DTO.MenteeDTO;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDAO courseDAO;
	
	@Autowired
	private MenteeDAO menteeDAO;
	
	@Override
	public void saveCourse(CourseDTO courseDTO) {
		courseDAO.save(courseDTO);
		
	}

	@Override
	public List<CourseDTO> getAllCourses() {
		List<CourseDTO> getallcourses=null;
		
		getallcourses=courseDAO.findAll();
		
		
		return getallcourses;
	}

	@Override
	public CourseDTO findById(long id) {
		CourseDTO courseDTO=null;
		
		courseDTO=courseDAO.findById(id);
		
		return courseDTO;
	}

	@Override
	public CourseDTO findByFullname(String fullname) {
		
		CourseDTO courseDTO=null;
		
		courseDTO=courseDAO.findByFullname(fullname);
		
		return courseDTO;
	}

	@Override
	public CourseDTO updateCourse(CourseDTO courseDTO, Long id) {
		CourseDTO existingCourse=null;
		
		existingCourse=findById(id);
		existingCourse.setFull_name(courseDTO.getFull_name());
		existingCourse.setSubject(courseDTO.getSubject());
		existingCourse.setTraining_duration(courseDTO.getTraining_duration());
		courseDAO.save(existingCourse);
		
		return existingCourse;
	}

	@Override
	public List<CourseDTO> findByFullname(String fullname, String subject) {
	   
		List<CourseDTO> courseDTO=null;
		
		courseDTO=courseDAO.findByFullnameOrSubject(fullname, subject);
		
		return courseDTO;
	}

	@Override
	public CourseDTO updateCourses(CourseDTO courseDTO, long id) {
		CourseDTO existingcourse=null;
		MenteeDTO existingMentee=null;
		
		existingcourse=findById(id);
		
		existingMentee=menteeDAO.findById(courseDTO.getMentee_id());
		
		existingcourse.setMentee_id(existingMentee.getMentee_id());
		
		return existingcourse;
	}

}
