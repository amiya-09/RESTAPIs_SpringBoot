package com.springboot.LearningRESTAPIs.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.springboot.LearningRESTAPIs.annotations.EmployeeRoleValidation;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private Long id;

    @NotBlank(message = "Required field in Employee: name")
    @Size(min = 3, max = 10, message = "Number of characters in name should be in the range: [3,10]")
    private String name;

    @NotBlank(message = "Email of the Employee cannot be blank")
    @Email(message = "Email should be a valid email")
    private String email;

    @NotNull(message = "Age of the employee cannot be blank")
    @Max(value = 60, message = "Age of employee cannot be greater than 60")
    @Min(value = 18, message = "Age of employee cannot be less than 18")
    private Integer age;

    @NotBlank(message = "Role of the Employee cannot be blank")
//    @Pattern(regexp = "^(ADMIN|USER)$", message = "Role of Employee can either be USER or ADMIN")
    @EmployeeRoleValidation
    private String role; // ROLE can be either ADMIN or USER

    @NotNull(message = "Salary of an Employee should not null")
    @Positive(message = "Salary of an Employee should be positive")
    @Digits(integer = 6, fraction = 2, message = "Salary : 6 digits before decimal and 2 after decimal allowed")  // 6 figure number and after decimal only 2 digits allowed
    @DecimalMax(value = "100000.99")
    @DecimalMin(value = "100.50")
    private Double salary;

    @PastOrPresent(message = "DateOfJoining field in Employee cannot be in the future")
    private LocalDate dateOfJoining;

    @AssertTrue(message = "Employee should be active")
    @JsonProperty("isActive")
    private Boolean isActive;

}
