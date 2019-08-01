package com.st.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.st.model.Student;
import com.st.service.IStudentService;

@RestController
@RequestMapping("/rest/student")
public class StudentRestController {

	@Autowired
	private IStudentService service;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveStudent(@RequestBody Student student){
		
		Integer id=service.saveStudent(student);
		ResponseEntity<String> responseEntity=
				new ResponseEntity<String>("Student Data inserted With id:"+id, HttpStatus.OK);
		
		return responseEntity;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAllStudent(){
		ResponseEntity<?> resp=null;
		List<Student> list=service.getAll();
		if(list!=null && !list.isEmpty())
			resp=new ResponseEntity<List<Student>>(list,HttpStatus.OK);
		else
			resp=new ResponseEntity<String>("No Data Found ", HttpStatus.INTERNAL_SERVER_ERROR);
		return resp;
	}
	@GetMapping("/getOne/{id}")
	public ResponseEntity<?> getOne(@PathVariable Integer id){
		ResponseEntity<?> res=null;
		Student student=service.getOne(id);
		if(student!=null) {
			res=new ResponseEntity<Student>(student,HttpStatus.OK);  	
		}
		else
			res=new  ResponseEntity<String>("Record No Found ",HttpStatus.INTERNAL_SERVER_ERROR);
		return res;
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmp(@PathVariable Integer id){
		ResponseEntity<String> resp=null;
		try {
			service.deleteStudent(id);
			resp=new ResponseEntity<String>("deleted'"+ id +"'Successfully",HttpStatus.OK);
		}catch (Exception e) {
			System.out.println(e.toString());
			resp=new ResponseEntity<String>("Unable to delete /Id not Found",HttpStatus.BAD_REQUEST);
		}	
		return resp;
	}
	@PutMapping("/update")
	public ResponseEntity<String> doUpdate(@RequestBody Student  student){
		ResponseEntity<String> resp=null;
		try {
		Integer id=service.doUpdate(student);
		resp=new ResponseEntity<String>("Updated Student With'"+ id +"'Successfully",HttpStatus.OK);
		}
		catch (Exception e) {
			resp=new ResponseEntity<String>("Updatation Failed",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return resp;
	} 
	
}
