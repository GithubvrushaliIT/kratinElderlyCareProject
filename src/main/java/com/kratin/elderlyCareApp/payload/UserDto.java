package com.kratin.elderlyCareApp.payload;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	
	
	private int id;
	@NotEmpty
	@Size(min = 10,message = "user must be min of 10 charactors")
	private String firstName;
	@NotNull
	@Size(min = 10,message = "user must be min of 10 charactors")
	private String lastName;
	@Email
	@Size(message = "Email address is not valid")
	private String email;
	@NotNull
	@Size(min=3,max=10,message = "password must be min of 3 chars and max of 10 char")
	
	private String password;
	@NotNull
	private String about;

}
