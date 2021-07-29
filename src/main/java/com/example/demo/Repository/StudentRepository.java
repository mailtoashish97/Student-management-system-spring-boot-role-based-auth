package com.example.demo.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Student;

 
@Repository
public interface StudentRepository extends JpaRepository<Student, Long>
{
@Query(value="select s.user_id, s.name,s.phone_no,s.email,s.address,s.password,s.upload_photo, c.c_name from user1 s Inner JOIN course c ON s.course=c.course_id", nativeQuery=true)
List<Object[]> findStudent();
}