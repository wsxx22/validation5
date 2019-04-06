package com.example.validation5.validator;

import com.example.validation5.annotation.ValidPesel;
import com.example.validation5.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PeselConstraintValidator implements ConstraintValidator<ValidPesel, String> {

    private UserRepo userRepo;

    @Autowired
    public PeselConstraintValidator(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public boolean isValid(String pesel, ConstraintValidatorContext constraintValidatorContext) {

        if (userRepo.existsByPesel(pesel)) {
            return false;
        }

        return true;
    }
}
