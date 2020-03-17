package com.petzo.DTO;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="mentees")
public class MenteeDTO {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="mentee_id")
	private Long mentee_id;
	
	@Column(name="full_name")
	private String full_name;
	
	@Column(name="application")
	private String application;
	
	@Column(name="portfolio")
	private String portfolio;
	
	@Column(name="local_mapping")
	private String local_mapping;
	
	@Column(name="mentor_id")
	private Long mentor_id;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="mentee_id")
	private List<CourseDTO> courseDTO;

	public MenteeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MenteeDTO(Long mentee_id, String full_name, String application, String portfolio, String local_mapping,
			Long mentor_id, List<CourseDTO> courseDTO) {
		super();
		this.mentee_id = mentee_id;
		this.full_name = full_name;
		this.application = application;
		this.portfolio = portfolio;
		this.local_mapping = local_mapping;
		this.mentor_id = mentor_id;
		this.courseDTO = courseDTO;
	}

	public Long getMentee_id() {
		return mentee_id;
	}

	public void setMentee_id(Long mentee_id) {
		this.mentee_id = mentee_id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public String getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(String portfolio) {
		this.portfolio = portfolio;
	}

	public String getLocal_mapping() {
		return local_mapping;
	}

	public void setLocal_mapping(String local_mapping) {
		this.local_mapping = local_mapping;
	}

	public Long getMentor_id() {
		return mentor_id;
	}

	public void setMentor_id(Long mentor_id) {
		this.mentor_id = mentor_id;
	}

	public List<CourseDTO> getCourseDTO() {
		return courseDTO;
	}

	public void setCourseDTO(List<CourseDTO> courseDTO) {
		this.courseDTO = courseDTO;
	}

	@Override
	public String toString() {
		return "MenteeDTO [mentee_id=" + mentee_id + ", full_name=" + full_name + ", application=" + application
				+ ", portfolio=" + portfolio + ", local_mapping=" + local_mapping + ", mentor_id=" + mentor_id
				+ ", courseDTO=" + courseDTO + "]";
	}
	
	
	
	
}
