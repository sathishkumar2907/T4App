package com.petzo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petzo.DAO.MenteeDAO;
import com.petzo.DAO.MentorDAO;
import com.petzo.DTO.MenteeDTO;
import com.petzo.DTO.MentorDTO;

@Service
public class MenteeServiceImpl implements MenteeService{

	@Autowired
	private MenteeDAO menteeDAO;
	
	@Autowired
	private MentorDAO mentorDAO;
	
	@Override
	public void saveMentee(MenteeDTO menteeDTO) {
		try{
			
			menteeDAO.save(menteeDTO);
			
		}catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		
	}

	@Override
	public List<MenteeDTO> getAllMentees() {
		List<MenteeDTO> getallmentees=null;
		
		try{
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return getallmentees;
	}

	@Override
	public MenteeDTO findById(long id) {
		
		MenteeDTO menteeDTO=null;
		
		try{
			
			menteeDTO=menteeDAO.findById(id);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return menteeDTO;
	}

	@Override
	public MenteeDTO updateMentee(MenteeDTO menteeDTO, long id) {
		MenteeDTO existingMentee=null;
		try{
			
			existingMentee=findById(id);
			
			existingMentee.setFull_name(menteeDTO.getFull_name());
			existingMentee.setApplication(menteeDTO.getApplication());
			existingMentee.setPortfolio(menteeDTO.getPortfolio());
			existingMentee.setLocal_mapping(menteeDTO.getLocal_mapping());
			menteeDAO.save(existingMentee);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return existingMentee;
	}

	@Override
	public MenteeDTO updateMenteeId(MenteeDTO menteeDTO, long id) {
		MenteeDTO existingmentee=null;
		MentorDTO existingmentor=null;
		
		try{
			
			existingmentee=findById(id);
			existingmentor=mentorDAO.findById(menteeDTO.getMentor_id());
			
			existingmentee.setMentor_id(existingmentor.getMentor_id());
			menteeDAO.save(existingmentee);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return existingmentee;
	}

}
