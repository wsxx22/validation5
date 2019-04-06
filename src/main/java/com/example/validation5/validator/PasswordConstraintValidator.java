package com.example.validation5.validator;


import com.example.validation5.annotation.ValidPassword;
import org.passay.*;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {

        context.disableDefaultConstraintViolation();

        if (password == null){
            context.buildConstraintViolationWithTemplate("Password cannot be null").addConstraintViolation();
            return false;
        }

        PasswordValidator passwordValidator = new PasswordValidator(List.of(
                new WhitespaceRule(),
                new UppercaseCharacterRule(1),
                new LengthRule(8,25),
                new SpecialCharacterRule(1),
                new DigitCharacterRule(1)
        ));

        RuleResult result = passwordValidator.validate(new PasswordData(password));

        if (result.isValid())
            return true;

        passwordValidator.getMessages(result).forEach(r -> {
                    context.buildConstraintViolationWithTemplate(r).addConstraintViolation();
                });

        return false;
    }
}
