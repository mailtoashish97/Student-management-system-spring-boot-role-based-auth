package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.Model.Course;
import com.example.demo.Model.StudentDAO;
import com.example.demo.Repository.StudentRepository;
import com.example.demo.Service.CourseService;
import com.example.demo.Service.StudentService;


@Controller
@RequestMapping("/")
public class IndexController {
	
	@Autowired
    private StudentService service;
   
	@Autowired
    private StudentRepository studentRepository;
   

	 
	 @Autowired
	 private CourseService services;

	 @RequestMapping(value="/student",method=RequestMethod.GET)
	 
	    public String viewstudentpage(Model model) {
	    	List<StudentDAO> li = new ArrayList<>();
	    	for(Object[] o : studentRepository.findStudent()) {
	    		StudentDAO student =new StudentDAO();
	    		student.setUser_id(Long.parseLong(String.valueOf(o[0])));
	    		student.setName((String) o[1]);
	    		student.setPhone_no((String) o[2]);
	    		student.setEmail((String) o[3]);
	    		student.setAddress((String) o[4]);
	    		student.setPassword((String) o[5]);
	    		student.setUpload_photo((String) o[6]);
	    		student.setCourse((String) o[7]);
	    		li.add(student);
	    	}
	    	
	    	model.addAttribute("liststudent",li);
	    	
	    	
	        return "student";
	    }
	 
	 
	 
	 
	 @RequestMapping(value="/",method=RequestMethod.GET)
	   public String index()
	   {
		  
	        return "index";
	   }
	 
	 
	 
	 @RequestMapping(value="/course",method=RequestMethod.GET)
	   public String viewHomePage(Model model)
	   {
		   List<Course> listcourse = services.listAll();
	        model.addAttribute("listcourse", listcourse);
	        return "course";
	   }

}
