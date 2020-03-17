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
import com.petzo.services.MenteeService;

@Controller
@RequestMapping(value="/mentee")
public class MenteeController {
	
	@Autowired
	private MenteeService menteeService;
	
	@GetMapping(value="/menteePage",produces="application/json")
	public String coursePage(){
		return "menteelist";
	}

	
	@RequestMapping(value="/mentee")
	public String courseSavePage(){
		return "mentee";
	}
	
	@PostMapping(value="/save", produces="application/json")
	@ResponseBody
	public Map<String,Object> saveMentee(@RequestBody MenteeDTO menteeDTO){
		Map<String,Object> responseMap=new HashMap<String, Object>();
	
		if(StringUtils.isEmpty(menteeDTO.getFull_name())){
			responseMap.put("status", "Failed");
			responseMap.put("errorMessage", "field is required");
			responseMap.put("data", null);
		}else{
			
			menteeService.saveMentee(menteeDTO);
			responseMap.put("errorMessage", "mentee is added successfully");
			responseMap.put("data", menteeDTO);
			
		}
		
		return responseMap;
		
	}
	
	@PostMapping(value="/{mentee_id}/save", produces="application/json")
	@ResponseBody
	public Map<String,Object> updateMenteeWithId(@PathVariable(value="mentor_id") Long mentor_id, @RequestBody MenteeDTO menteeDTO){
		MenteeDTO menteeDTOObj=null;
		Map<String,Object> responseMap=new HashMap<String, Object>();
		
		menteeDTOObj=menteeService.updateMentee(menteeDTO, mentor_id);
		responseMap.put("errorMessage", "mentee is updated successfully");
		responseMap.put("data", menteeDTOObj);
		
		return responseMap;
	}
	
	
   @GetMapping(value="/", produces="application/json")
	@ResponseBody
	public Map<String,Object> getAllMentees(){
	   Map<String,Object> responseMap=new HashMap<String, Object>();
	   List<MenteeDTO> getallmentees;
	   
	   getallmentees=menteeService.getAllMentees();
	   responseMap.put("data", getallmentees);
	   
	   return responseMap;
	   
   }
	
	
	
	@PutMapping(value="/update/{id}",produces="application/json", consumes="application/json")
	@ResponseBody
	public Map<String,Object> updateMentee(@RequestBody MenteeDTO menteeDTO, @PathVariable long id){
		 Map<String,Object> responseMap=new HashMap<String, Object>();
		 
		MenteeDTO menteeDTOObj= menteeService.updateMentee(menteeDTO, id);
		responseMap.put("data", menteeDTOObj);
		responseMap.put("message", "Mentee Details updated");
		return responseMap;
	}
	
	
	
	
	
	
	
}

