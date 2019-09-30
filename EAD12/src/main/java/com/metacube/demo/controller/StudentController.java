package com.metacube.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.metacube.demo.dto.SearchStudentDto;
import com.metacube.demo.dto.Student;
import com.metacube.demo.entity.StudentEntity;
import com.metacube.demo.services.StudentService;
import com.metacube.demo.util.DtoUtil;

/**
 * Controller class to handle the request mapping
 * @author Rahul
 *
 */
@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentRepo;
	
	@Value("${home.message}")
	private String message;

	@GetMapping("/")
	public String getHome1(Model model) {
		model.addAttribute("message" ,message);
		return "home";
	}
	
	/**
	 * request come from web server /Home then page redirect is home.jsp
	 * @param model
	 * @return
	 */
	@GetMapping("/home")
	public String getHome(Model model) {
		model.addAttribute("message" ,message);
		return "home";
	}

	/**
	 * when web server request /showStudent then page showStudent.jsp will show
	 * @param model
	 * @return
	 */
	@GetMapping("/showAllStudent")
	public String displayStudent(Model model) {
		model.addAttribute("listOfStudents", studentRepo.getAll());
		return "showStudent";
		
	}
	

	/**
	 * when web server signUp page is refect then it return addStudent
	 * @param model
	 * @return
	 */
	@GetMapping("/addStudent")
	public String doSignUp(Model model) {
		model.addAttribute("student", new Student());
		return "addStudent";
	}
	
	/**
	 * when user request as post method then this function is called
	 * @param student
	 * @param errorResult
	 * @param model
	 * @return
	 */
	@PostMapping("/addStudent")
	public String doSignupByPost(@ModelAttribute("student") @Validated Student student , BindingResult errorResult , Model model) {
		if(errorResult.hasErrors()) {
//			ObjectError oe = new  ObjectError("email","Fill The Form");
//			errorResult.addError(oe);
			return "addStudent";
		} else {
			List<StudentEntity> studentData = studentRepo.duplicateEmail(DtoUtil.map(student,StudentEntity.class));
			if(studentData.size()>0) {
				
				model.addAttribute("success", "Student Already Exist");
				return "addStudent";
			} 
			studentRepo.insertData(DtoUtil.map(student,StudentEntity.class));
			model.addAttribute("student", student);
			model.addAttribute("success", "Student added Successfully");
			return "successfully";
		}
	}
	

	@GetMapping("/searchStudent") 
	public String searchStudentByGet(Model model) {
		model.addAttribute("SearchCommand", new SearchStudentDto());
		return "Search";
	}
	
	
	@PostMapping("/searchStudent") 
	public String searchStudentByPost(@ModelAttribute("SearchCommand") @Validated SearchStudentDto student , BindingResult errorResult , Model model) {
		List<StudentEntity> studentData = studentRepo.findByID(DtoUtil.map(student,StudentEntity.class));
		if(studentData.size()>0) {
			System.out.println(studentData.get(0).getEmail());
			model.addAttribute("studentData", studentData);
			return "Search";
		}
		model.addAttribute("success", "No Student  Find");
		return "Search";
	}


}
