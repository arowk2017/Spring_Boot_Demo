/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codecliquesoftware.demo4;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Email(message = "Email invalid")
@Pattern(regexp=".+@.+\\..+", message="Valid email address required")
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Documented
public @interface CustomEmailValidator {
    String message() default "Valid email address required";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}