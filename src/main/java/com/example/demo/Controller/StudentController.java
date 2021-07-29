package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Model.Course;
import com.example.demo.Model.Student;
import com.example.demo.Service.CourseService;
import com.example.demo.Service.StudentService;
 

 
@Controller
@RequestMapping("/student")
 
public class StudentController {
	
	
	 @Autowired
	    private StudentService service;
	 
	 @Autowired
	 private CourseService services;
 
	    @GetMapping("/addstudent")
	    public String add(Model model) {
	    	List<Student> liststudent = service.listAll();
	    	List<Course> listcourse = services.listAll();
		    model.addAttribute("listcourse", listcourse);
	        model.addAttribute("liststudent", liststudent);
	        model.addAttribute("student", new Student());
	        return "addstudent";
	    }
	    
	    
	    @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String saveStudent(@ModelAttribute("student") Student std) 
	    {
	        service.save(std);
	        return "redirect:/student";
	    }
	    
 
	    @RequestMapping("/edit/{user_id}")
	    public ModelAndView showEditStudentPage(@PathVariable(name = "user_id") Long user_id) {
	        ModelAndView mav = new ModelAndView("addstudent");
	        List<Course> listcourse = services.listAll();
		
	        Student std = service.get(user_id);
	        mav.addObject("student", std);
	        return mav;
	        
	    }
	    @RequestMapping("/delete/{user_id}")
	    public String deleteStudentPage(@PathVariable(name = "user_id") Long user_id) {
	        service.delete(user_id);
	        return "redirect:/student";
	    }
	
	
 
}