package com.te.beanvalidation.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.te.beanvalidation.annotation.EmployeePasswordValidator;
import com.te.beanvalidation.annotation.EmployeeTypeValidator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	
	@Id
	private Integer empId;
	
	@NotEmpty
	@Size(min = 2,message = "Atlesat 2 and maximum 20 character")
	private String empName;
	
	@Email
	private String emailId;
	
	@NotEmpty
	@EmployeePasswordValidator
	private String password;
	
	@JsonFormat(pattern = "dd/MM/yy")
	private LocalDate dob;
	
	@EmployeeTypeValidator(message = "Type Not Exist")
	private String type;

}
