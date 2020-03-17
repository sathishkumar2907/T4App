package com.petzo.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="courses")
public class CourseDTO {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="course_id")
	private Long course_id;
	
	@Column(name="full_name")
	private String full_name;
	
	@Column(name="subject")
	private String subject;
	
	@Column(name="training_duration")
	private String training_duration;
	
	@Column(name="mentee_id")
	private Long mentee_id;

	public CourseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CourseDTO(Long course_id, String full_name, String subject, String training_duration, Long mentee_id) {
		super();
		this.course_id = course_id;
		this.full_name = full_name;
		this.subject = subject;
		this.training_duration = training_duration;
		this.mentee_id = mentee_id;
	}

	public Long getCourse_id() {
		return course_id;
	}

	public void setCourse_id(Long course_id) {
		this.course_id = course_id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTraining_duration() {
		return training_duration;
	}

	public void setTraining_duration(String training_duration) {
		this.training_duration = training_duration;
	}

	public Long getMentee_id() {
		return mentee_id;
	}

	public void setMentee_id(Long mentee_id) {
		this.mentee_id = mentee_id;
	}

	@Override
	public String toString() {
		return "CourseDTO [course_id=" + course_id + ", full_name=" + full_name + ", subject=" + subject
				+ ", training_duration=" + training_duration + ", mentee_id=" + mentee_id + "]";
	}
	
	
	
	
}
