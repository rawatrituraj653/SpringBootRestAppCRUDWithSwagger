package com.st.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.st.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
