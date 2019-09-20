package com.metacube.demo.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author Rahul
 *
 */
public class Student {

	int id;

	@NotNull(message = "is required")
	@Size(min = 2, max = 40, message = "{student.firstNameSizeValidation}")
	@Pattern(regexp = "^[A-Za-z]*", message = "{student.firstNamePatternValidation}")
	private String firstName = null;

	private String lastName = null;

	@NotNull(message = "is required")
	@Size(min = 2, max = 40, message = "{student.fatherNameSizeValidation}")
	@Pattern(regexp = "^[A-Za-z. ]*", message = "{student.fatherNamePatternValidation}")
	private String fatherName = null;

	@NotNull(message = "is required")
	@Pattern(regexp = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$", message = "{student.emailPatternValidation}")
	private String email;

	@NotNull(message = "is required")
	@Min(value = 3, message = "{student.ageMinValidation}")
	@Max(value = 30, message = "{student.ageMaxValidation}")
	private int age;

	@NotNull
	@NotBlank(message = "{class}")
	@Size(min = 1, max = 12)
	@Pattern(regexp = "^[0-9]+", message = "{validclass}")
	String studentClass;

	public Student() {

	}

	/**
	 * Constructor to start all the filled
	 * 
	 * @param firstName
	 * @param lastName
	 * @param fatherName
	 * @param sClass
	 * @param email
	 * @param studentAge
	 */
	public Student(int id, String firstName, String lastName, String fatherName, String studentClass, String email,
			int age) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.fatherName = fatherName;
		this.studentClass = studentClass;
		this.email = email;
		this.age = age;

	}

	
	public String getFirstName() {
		return firstName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
