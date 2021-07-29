package com.example.demo.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.Model.Course;
 
@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{
 
}