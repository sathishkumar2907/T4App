package com.petzo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.petzo.DTO.MenteeDTO;
import com.petzo.DTO.MentorDTO;
import com.petzo.services.MentorService;

@Controller
@RequestMapping(value="mentor")
public class MentorController {

	@Autowired
	private MentorService mentorService;
	
	@GetMapping(value="/mentorPage",produces="application/json")
	public String mentorPage(){
		return "mentorlist";
	}
	
	@RequestMapping(value="/mentor")
	public String courseSavePage(){
		return "mentor";
	}
	
	@GetMapping(value="/savementorTomentee", produces="application/json")
	public String savementorTomentee(){
		return "mentorTomentee";
	}
	
	@GetMapping(value="mentorTomenteelistPage", produces="application/json")
	public String mentorTomenteelist(){
		return "mentorTomenteelist";
	}
	
	
	@PostMapping(value="/save", produces="application/json")
	@ResponseBody
	public Map<String, Object> saveMentor(@RequestBody MentorDTO mentorDTO){
		Map<String, Object> responseMap=new HashMap<>();
		
		if(StringUtils.isEmpty(mentorDTO.getFull_name()) && mentorDTO.getFull_name().equals("")){
			responseMap.put("status", "Failed");
			responseMap.put("errorMessage", "Field is Required");
			responseMap.put("data", null);
			
		}else{
			mentorService.saveMentor(mentorDTO);
			responseMap.put("Message", "Mentor is added successfully");
			responseMap.put("data", mentorDTO);
			
		}
		return responseMap;
	}
	
	
	
	@GetMapping(value="/", produces="application/json")
	@ResponseBody
	public Map<String, Object> getAllMentor(){
		Map<String, Object> responseMap=new HashMap<>();
         List<MentorDTO> getallmentor;
         getallmentor=mentorService.getAllMentors();
         responseMap.put("data", getallmentor);
         return responseMap;
         
	}
	
	
	@PutMapping(value="/update/{id}", produces="application/json")
	@ResponseBody
	public Map<String, Object> updateCourse(@RequestBody MentorDTO mentorDTO,@PathVariable Long id){
		MentorDTO mentorDTOObj=null;
		Map<String, Object> responseMap=new HashMap<>();
		
		mentorDTOObj=mentorService.updateMentor(mentorDTO, id);
		responseMap.put("Message", "Mentor is updated successfully");
		responseMap.put("data", mentorDTOObj);
		return responseMap;
		
	}
	
	
	@GetMapping(value="/{mentorId}/mentees", produces="application/json")
	@ResponseBody
	public Map<String, Object> getMenteesByMentor(@PathVariable("mentorId") Long mentorId){
		Map<String, Object> responseMap=new HashMap<>();
         List<MenteeDTO> getMenteesByMentor;
         getMenteesByMentor=mentorService.getMenteesByMentor(mentorId);
         responseMap.put("data", getMenteesByMentor);
         return responseMap;
         
	}
	
	
	
	
	
	
}
