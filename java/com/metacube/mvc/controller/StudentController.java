package com.metacube.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.metacube.mvc.model.Student;

/** controller class to handle requrest to resolve the mapping
 * @author Rahul
 *
 */
@Controller
public class StudentController {

	List<Student> listOfStudents =  new ArrayList<Student>();
	
	@Value("${welcome.message}")
	String message;
	@RequestMapping("/")
	public String home(Model model)
	{
		model.addAttribute("message", message);
		return "home";
	}
	
	@RequestMapping("/showStudentForm")
	public String addStudent(Model model)
	{
		model.addAttribute("student", new Student());
		return "student-form";
	}
	
	@RequestMapping("/ProcessStudentForm")
	public String processStudentForm(@Valid @ModelAttribute("student")Student student, BindingResult bindingResult, Model model)
	{
		System.out.println("student information");
		System.out.println();
		System.out.println();
		
		System.out.println("first name: " + student.getFirstName());
		
		System.out.println("last name: " + student.getLastName());
		
		System.out.println("father name: " + student.getFatherName());
		
		System.out.println("email: " + student.getEmail());
		
	
		System.out.println("age: " + student.getAge());
		
		model.addAttribute("listOfStudents", listOfStudents);
		
		if(bindingResult.hasErrors())
		{
			System.out.println("form has error:");
			return "student-form";
		}
		else
		{	
			listOfStudents.add(student);
			return "show-students";
		}
	}
	
}
