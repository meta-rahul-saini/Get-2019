package com.metacube.mvc.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**function to store login credentials
 * @author Rahul
 *
 */
public class Login {
	
	@Email(message = "{validEmail}")
	@NotBlank(message = "{blankEmail}")
	private String email;
	
	@NotBlank(message = "{blankPassword}")
	private String password;
	
	private String credentials;
	
	public String getCredentials() {
		return credentials;
	}
	public void setCredentials(String credentials) {
		this.credentials = credentials;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
