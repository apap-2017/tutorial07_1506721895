package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.CourseModel;
import com.example.model.StudentModel;
import com.example.service.CourseService;

@Controller
public class CourseController {
	@Autowired
	CourseService courseDAO;
	
	  @RequestMapping("/course/view/{id}")
	    public String viewCourse (Model model, @PathVariable(value="id") String id)
	    {
	    CourseModel course = courseDAO.selectCourse(id);
	    if(course!=null) {
	    		model.addAttribute("course" , course);
	    			return "viewCourse";
	    	}
	    else {
	    		model.addAttribute("id" , id);
	    		return "not-found-course";
	    		}
	    
	    }
	  @RequestMapping("/course/viewall")
	    public String view (Model model)
	    {
	        List<CourseModel> courses = courseDAO.selectAllCourse();
	        model.addAttribute ("courses", courses);

	        return "viewall-course";
	    }
}
