package com.te.beanvalidation.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmployeePassword  implements ConstraintValidator<EmployeePasswordValidator, String>{

	@Override
	public boolean isValid(String password, ConstraintValidatorContext context) {

		Integer length = password.length();
		if (length>=2&&length<=8) {
			return true;
		}
		return false;
	}

}
