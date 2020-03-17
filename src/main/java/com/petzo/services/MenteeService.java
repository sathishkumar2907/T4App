package com.petzo.services;

import java.util.List;

import com.petzo.DTO.MenteeDTO;

public interface MenteeService {

	void saveMentee(MenteeDTO menteeDTO);
	List<MenteeDTO> getAllMentees();
	MenteeDTO findById(long id);
	MenteeDTO updateMentee(MenteeDTO menteeDTO, long id);
	MenteeDTO updateMenteeId(MenteeDTO menteeDTO, long id);
	
}
