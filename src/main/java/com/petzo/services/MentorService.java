package com.petzo.services;

import java.util.List;

import com.petzo.DTO.MenteeDTO;
import com.petzo.DTO.MentorDTO;

public interface MentorService{

	void saveMentor(MentorDTO mentorDTO);
	List<MentorDTO> getAllMentors();
	MentorDTO findById(long id);
	MentorDTO updateMentor(MentorDTO mentorDTO, long id);
	List<MenteeDTO> getMenteesByMentor(Long mentorId);
	
}
