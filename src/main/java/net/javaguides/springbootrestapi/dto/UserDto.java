package net.javaguides.springbootrestapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class UserDto {
	
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
	private long id;
	
	//User First name should not be null or empty
	@NotEmpty(message= "User first name should not be null or empty")
	private String firstName;
	
	//User last name should not be null or empty
	@NotEmpty(message="User last name should not be empty or null ")
	private String lastName;
	
	//User email should not be null or empty
	//Email address should be valid
	
	@NotEmpty
	@Email(message="User email should not be null of empty")
	private String email;

}
