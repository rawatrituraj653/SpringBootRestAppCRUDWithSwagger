package com.st.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.model.Student;
import com.st.repo.StudentRepository;
import com.st.service.IStudentService;

@Service
public class StudentService implements IStudentService {

	@Autowired
	private StudentRepository repo;

	@Override
	@Transactional
	public Integer saveStudent(Student student) {
		
		Student stu=repo.save(student);
		
		return stu.getStdId();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Student> getAll() {
		
		List<Student> stu=repo.findAll();
		//stu.stream().sorted((s1,s2)->s1.getStdName().compareTo(s2.getStdName()));
		Collections.sort(stu, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
		
				return o1.getStdName().compareTo(o2.getStdName());
			}
		});
		if(stu !=null && !stu.isEmpty()) {
			return stu;
		}
		else
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public Student getOne(Integer id) {
	Optional<Student> opt=	repo.findById(id);
	if(opt.isPresent()) {
		return opt.get();
	}
	else
		return null;
	}
	
	@Override
	@Transactional
	public void deleteStudent(Integer id) {
	try {
		repo.deleteById(id);
	}catch (Exception e) {
		System.out.println("hello");
		throw new RuntimeException("This id is not exist");
	}	
	}
	
	@Override
	@Transactional
	public Integer doUpdate(Student student) {
	
		return repo.save(student).getStdId();
	}
}
