package com.te.beanvalidation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = EmployeePassword.class)
public @interface EmployeePasswordValidator {
	
public String message() default"Password length should between 2 and 8 characters";
	
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

}
