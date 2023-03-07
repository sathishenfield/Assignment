package com.te.beanvalidation.annotation;

import java.util.Arrays;
import java.util.List;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmployeeType implements ConstraintValidator<EmployeeTypeValidator, String> {

	@Override
	public boolean isValid(String type, ConstraintValidatorContext context) {
		 
		List<String> employeeType=Arrays.asList("permanent","vendor");
		
		return employeeType.contains(type);
		 
	}

}
