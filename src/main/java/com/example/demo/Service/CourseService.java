package com.example.demo.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Course;
import com.example.demo.Repository.CourseRepository;

 
@Service
public class CourseService 
{
	@Autowired
    private CourseRepository repo;
	
	public List<Course> listAll() {
        return repo.findAll();
    }
     
    public void save(Course course) {
        repo.save(course);
    }
     
    public Course get(Long course_id) {
        return repo.findById( course_id).get();
    }
     
    public void delete(Long course_id) {
        repo.deleteById( course_id);
    }
 
}