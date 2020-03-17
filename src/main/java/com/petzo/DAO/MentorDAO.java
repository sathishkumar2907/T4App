package com.petzo.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.petzo.DTO.MenteeDTO;
import com.petzo.DTO.MentorDTO;

public interface MentorDAO extends JpaRepository<MentorDTO, Long>{

	MentorDTO findById(long id);
	
	@Query("select mentor.menteeDTO from MentorDTO AS mentor where mentor.mentor_id=:mentorId")
	List<MenteeDTO> getMenteesByMentor(@Param("mentorId") Long mentorId);
}
