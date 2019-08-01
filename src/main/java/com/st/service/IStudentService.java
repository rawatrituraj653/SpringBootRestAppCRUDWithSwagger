package com.st.service;

import java.util.List;

import com.st.model.Student;

public interface IStudentService {

	public Integer saveStudent(Student student );
	
	public List<Student> getAll();
	
	public Student getOne(Integer id);
	public void deleteStudent(Integer id);
	public Integer doUpdate(Student student);
}
