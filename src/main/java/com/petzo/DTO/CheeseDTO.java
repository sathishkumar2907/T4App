package com.petzo.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="cheese")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,property="cheese_id")
public class CheeseDTO {

	@Id
	@Column(name="cheese_id")
	private Long cheese_id;
	
	@Column(name="full_name")
	private String full_name;
	
	@Column(name="application")
	private String application;
	
	@Column(name="portfolio")
	private String portfolio;
	
	@Column(name="local_mapping")
	private String local_mapping;
	
	private transient Long category_mentor_id;
	
	@ManyToOne
	@JoinColumn(name="category_mentor_id")
	private Category category;

	public CheeseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CheeseDTO(Long cheese_id, String full_name, String application, String portfolio, String local_mapping,
			Long category_mentor_id, Category category) {
		super();
		this.cheese_id = cheese_id;
		this.full_name = full_name;
		this.application = application;
		this.portfolio = portfolio;
		this.local_mapping = local_mapping;
		this.category_mentor_id = category_mentor_id;
		this.category = category;
	}

	public Long getCheese_id() {
		return cheese_id;
	}

	public void setCheese_id(Long cheese_id) {
		this.cheese_id = cheese_id;
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

	public Long getCategory_mentor_id() {
		return category_mentor_id;
	}

	public void setCategory_mentor_id(Long category_mentor_id) {
		this.category_mentor_id = category_mentor_id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "CheeseDTO [cheese_id=" + cheese_id + ", full_name=" + full_name + ", application=" + application
				+ ", portfolio=" + portfolio + ", local_mapping=" + local_mapping + ", category=" + category + "]";
	}
	
	
	
}
