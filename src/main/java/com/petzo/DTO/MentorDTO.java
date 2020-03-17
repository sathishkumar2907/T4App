package com.petzo.DTO;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="mentors")
public class MentorDTO {
	
	@Id
	@Column(name="mentopr_id")
	private Long mentor_id;
	
	@Column(name="full_name")
	private String full_name;
	
	@Column(name="primary_skillset")
	private String primary_skillset;
	
	@Column(name="secondary_skillset")
	private String secondary_skillset;
	
	@Column(name="years_of_experience")
	private String years_of_experience;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="mentee_id")
	private List<MenteeDTO> menteeDTO;

	public MentorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MentorDTO(Long mentor_id, String full_name, String primary_skillset, String secondary_skillset,
			String years_of_experience, List<MenteeDTO> menteeDTO) {
		super();
		this.mentor_id = mentor_id;
		this.full_name = full_name;
		this.primary_skillset = primary_skillset;
		this.secondary_skillset = secondary_skillset;
		this.years_of_experience = years_of_experience;
		this.menteeDTO = menteeDTO;
	}

	public Long getMentor_id() {
		return mentor_id;
	}

	public void setMentor_id(Long mentor_id) {
		this.mentor_id = mentor_id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getPrimary_skillset() {
		return primary_skillset;
	}

	public void setPrimary_skillset(String primary_skillset) {
		this.primary_skillset = primary_skillset;
	}

	public String getSecondary_skillset() {
		return secondary_skillset;
	}

	public void setSecondary_skillset(String secondary_skillset) {
		this.secondary_skillset = secondary_skillset;
	}

	public String getYears_of_experience() {
		return years_of_experience;
	}

	public void setYears_of_experience(String years_of_experience) {
		this.years_of_experience = years_of_experience;
	}

	public List<MenteeDTO> getMenteeDTO() {
		return menteeDTO;
	}

	public void setMenteeDTO(List<MenteeDTO> menteeDTO) {
		this.menteeDTO = menteeDTO;
	}

	@Override
	public String toString() {
		return "MentorDTO [mentor_id=" + mentor_id + ", full_name=" + full_name + ", primary_skillset="
				+ primary_skillset + ", secondary_skillset=" + secondary_skillset + ", years_of_experience="
				+ years_of_experience + ", menteeDTO=" + menteeDTO + "]";
	}
	
	
}
