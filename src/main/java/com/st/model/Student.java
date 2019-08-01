package com.st.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="STUDENT_TAB")
@Data
public class Student {

	@Id
	@GeneratedValue
	@Column(name="STD_ID")
	private Integer stdId;
	@Column(name="STD_NAME")
	private String stdName;
	@Column(name="STD_FEE")
	private double stdFee;
	@Column(name="STD_GENDER")
	private String stdGen;
	@Column(name="STD_COURSE")
	private String stdCourse;
}
