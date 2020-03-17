package com.petzo.DTO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="mentor_id")
	private Long mentor_id;
	
	@Column(name="full_name")
	private String full_name;
	
	@Column(name="primary_skillset")
	private String primary_skillset;
	
	@Column(name="secondary_skillset")
	private String secondary_skillset;
	
	@Column(name="years_of_experience")
	private String years_of_experience;
	
	@OneToMany(mappedBy="category")
	private List<CheeseDTO> cheeses=new ArrayList<>();

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(Long mentor_id, String full_name, String primary_skillset, String secondary_skillset,
			String years_of_experience, List<CheeseDTO> cheeses) {
		super();
		this.mentor_id = mentor_id;
		this.full_name = full_name;
		this.primary_skillset = primary_skillset;
		this.secondary_skillset = secondary_skillset;
		this.years_of_experience = years_of_experience;
		this.cheeses = cheeses;
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

	public List<CheeseDTO> getCheeses() {
		return cheeses;
	}

	public void setCheeses(List<CheeseDTO> cheeses) {
		this.cheeses = cheeses;
	}

	@Override
	public String toString() {
		return "Category [mentor_id=" + mentor_id + ", full_name=" + full_name + ", primary_skillset="
				+ primary_skillset + ", secondary_skillset=" + secondary_skillset + ", years_of_experience="
				+ years_of_experience + ", cheeses=" + cheeses + "]";
	}
	
	

}
