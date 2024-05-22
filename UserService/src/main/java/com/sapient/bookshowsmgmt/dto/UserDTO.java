package com.sapient.bookshowsmgmt.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDTO {
	private Long id;
	@NotEmpty(message = "Username is required")
	@Size(min = 4, max = 20, message = "Username must be between 4 and 20 characters")
	private String username;
	@NotEmpty(message = "Password is required")
	@Size(min = 6, message = "Password must be at least 6 characters")
	private String password;
	@NotEmpty(message = "Email is required")
	@Email(message = "Email should be valid")
	private String email;
}