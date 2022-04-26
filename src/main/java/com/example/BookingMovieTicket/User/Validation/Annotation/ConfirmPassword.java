package com.example.BookingMovieTicket.User.Validation.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.example.BookingMovieTicket.User.Validation.Validator.ConfirmPasswordValidator;

@Constraint(validatedBy=ConfirmPasswordValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ConfirmPassword {
	String message() default "password does not match";
	Class<?>[] groups() default { };
	
	Class<? extends Payload>[] payload() default { };

}
