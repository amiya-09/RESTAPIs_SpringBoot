package com.springboot.LearningRESTAPIs.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class EmployeeRoleValidator implements ConstraintValidator<EmployeeRoleValidation, String> {
    @Override
    public boolean isValid(String inputRole, ConstraintValidatorContext context) {
        // check if inputRole is valid or not, valid if either it is ADMIN or USER
        if(inputRole == null) return false;
        List<String> roles = List.of("USER", "ADMIN");
        return roles.contains(inputRole);
    }
}
