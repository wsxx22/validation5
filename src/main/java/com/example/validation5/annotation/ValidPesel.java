package com.example.validation5.annotation;

import com.example.validation5.validator.PeselConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = PeselConstraintValidator.class)
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPesel {

    String message() default "Invalid pesel";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
