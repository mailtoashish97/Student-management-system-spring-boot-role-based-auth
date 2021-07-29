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
import com.example.demo.Service.CourseService;

 
@Controller
@RequestMapping("/course")
public class CourseController {
	
	 @Autowired
	  private CourseService service;
        
	  
	    @GetMapping("/addcourse")
	    public String add(Model model) {
	    	List<Course> listcourse = service.listAll();
	        model.addAttribute("listcourse", listcourse);
	        model.addAttribute("course", new Course());
	        return "addcourse";
	    }
 
	    @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String saveCourse(@ModelAttribute("course") Course course) {
	        service.save(course);
	        return "redirect:/course";
	    }
 
	    @RequestMapping("/edit/{course_id}")
	    public ModelAndView showEditCoursePage(@PathVariable(name = "course_id") Long course_id) {
	        ModelAndView mav = new ModelAndView("addcourse");
	        Course course = service.get(course_id);
	        mav.addObject("course", course);
	        return mav;
	        
	    }
	    @RequestMapping("/delete/{course_id}")
	    public String deleteCoursePage(@PathVariable(name = "course_id") Long course_id) {
	        service.delete(course_id);
	        return "redirect:/course";
	    }
}