package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Course;
import com.example.demo.Model.Student;
import com.example.demo.Repository.StudentRepository;
 

 
@Service
public class StudentService {
 
	@Autowired
    private StudentRepository repo;
	
	public List<Student> listAll() 
	{
		System.out.println(repo.findAll());
        return repo.findAll();
    }
     
 
    public void save(Student std) {
        repo.save(std);
    }
     
    public Student get(long user_id) {
        return repo.findById(user_id).get();
    }
     
    public void delete(long user_id) {
        repo.deleteById(user_id);
    }
 
}
