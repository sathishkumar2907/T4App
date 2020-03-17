package com.petzo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.petzo.DTO.CourseDTO;
import com.petzo.services.CourseService;

@Controller
@RequestMapping(value="/course")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping(value="/T2App", produces="application/json")
	public String T2App(){
		return "navigationMenu";
	}
	
	@GetMapping(value="/coursePage", produces="application/json")
	public String coursePage(){
		return "courselist";
	}
	
	@GetMapping(value="/course", produces="application/json")
	public String courseSavePage(){
		return "course";
	}

	
	@GetMapping(value="/home", produces="application/json")
	public String home(){
		return "home";
	}
	
	@GetMapping(value="/index", produces="application/json")
	public String index(){
		return "index";
	}
	
	@PostMapping(value="/save", produces="application/json")
	@ResponseBody
	public Map<String,Object> saveCourse(@RequestBody CourseDTO courseDTO){
		Map<String,Object> responseMap=new HashMap<String, Object>();
		
		courseService.saveCourse(courseDTO);
		responseMap.put("data", courseDTO);
		responseMap.put("message", "course is added");
		
		return responseMap;
		
	}
	
	
	
	@PutMapping(value="/{mentee_id}/save",produces="application/json")
	@ResponseBody
	public Map<String,Object> updateCourseWithId(@PathVariable(value="mentee_id") long mentee_id,@RequestBody CourseDTO courseDTO){
		Map<String,Object> responseMap=new HashMap<String, Object>();
		CourseDTO courseDTOObj;
		
		courseDTOObj=courseService.updateCourse(courseDTO, mentee_id);
		responseMap.put("data", courseDTOObj);
		responseMap.put("message", "course is updated");
		return responseMap;
		
	}
	
	@GetMapping(value="/", produces="application/json")
	@ResponseBody
	public Map<String,Object> getAllCourses(){
		Map<String,Object> responseMap=new HashMap<String, Object>();
		List<CourseDTO> getallcourses;
		getallcourses=courseService.getAllCourses();
		responseMap.put("data", getallcourses);
		
		return responseMap;
	}
	
	
	@GetMapping(value="/{fullname}", produces="application/json")
	@ResponseBody
	public Map<String,Object> getAllCoursesWithName(@PathVariable(value="fullname") String fullname){
		Map<String,Object> responseMap=new HashMap<String, Object>();
		
		List<CourseDTO> getFullnamecourse;
		
		getFullnamecourse=courseService.findByFullname(fullname,fullname);
		responseMap.put("data", getFullnamecourse);
		
		return responseMap;
	}
	
}



























