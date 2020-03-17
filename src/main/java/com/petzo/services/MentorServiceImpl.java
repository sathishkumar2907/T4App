package com.petzo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petzo.DAO.MentorDAO;
import com.petzo.DTO.MenteeDTO;
import com.petzo.DTO.MentorDTO;

@Service
public class MentorServiceImpl implements MentorService {
	
	
	@Autowired
	private MentorDAO mentorDAO;

	@Override
	public void saveMentor(MentorDTO mentorDTO) {
		try{
			
			mentorDAO.save(mentorDTO);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<MentorDTO> getAllMentors() {
		List<MentorDTO> getallmentor=null;
		
        try{
			
        	getallmentor=mentorDAO.findAll();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return getallmentor;
	}

	@Override
	public MentorDTO findById(long id) {
		MentorDTO mentorDTO=null;
        try{
			
        	mentorDTO=mentorDAO.findById(id);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return mentorDTO;
	}

	@Override
	public MentorDTO updateMentor(MentorDTO mentorDTO, long id) {
		
		MentorDTO existingMentor=null;
		
		 try{
				
			 existingMentor=findById(id);
			 existingMentor.setFull_name(mentorDTO.getFull_name());
			 existingMentor.setPrimary_skillset(mentorDTO.getPrimary_skillset());
			 existingMentor.setSecondary_skillset(mentorDTO.getSecondary_skillset());
			 existingMentor.setYears_of_experience(mentorDTO.getYears_of_experience());
			 
			 
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		
		
		return existingMentor;
	}

	@Override
	public List<MenteeDTO> getMenteesByMentor(Long mentorId) {
		
		List<MenteeDTO> menteelist=null;
		
		try{
			
			menteelist=mentorDAO.getMenteesByMentor(mentorId);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return menteelist;
	}

}
