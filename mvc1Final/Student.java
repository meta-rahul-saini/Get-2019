package com.metacube.mvc1Final;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * POJO class to represent student details
 * @author Rahul
 *
 */
public class Student {

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

	private List<String> standards = new ArrayList<String>();

	
	public List<String> getStandards() {
		return standards;
	}
	
	public void setStandards(List<String> standards) {
		this.standards = standards;
	}
	public Student() {
		standards.add("first");
		standards.add("second");
		standards.add("third");
		standards.add("fourth");
		standards.add("fifth");
	}
	public String getFirstName() {
		return firstName;
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


	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
