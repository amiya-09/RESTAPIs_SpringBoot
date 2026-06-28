package com.springboot.LearningRESTAPIs.controllers;

import com.springboot.LearningRESTAPIs.dto.EmployeeDTO;
import com.springboot.LearningRESTAPIs.entities.EmployeeEntity;
import com.springboot.LearningRESTAPIs.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable(name = "employeeId") Long id) {
        return employeeService.getEmployeeById(id);
    }
    @GetMapping
    public List<EmployeeDTO> getAllEmployees(@RequestParam(required = false) Integer age,
                                                @RequestParam(required = false) String  sortBy) {
        return employeeService.getAllEmployees();
    }
    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee) {
        return employeeService.createNewEmployee(inputEmployee);
    }
    @PutMapping(path = "/{employeeId}")
    public EmployeeDTO updateEmployeeById(@RequestBody EmployeeDTO employeeDTO, @PathVariable Long employeeId){
        return employeeService.updateEmployeeById(employeeId, employeeDTO);
    }
    @DeleteMapping(path = "/{employeeId}")
    public boolean deleteEmployeeById(@PathVariable Long employeeId){
        return employeeService.deleteEmployeeById(employeeId);
    }
    @PatchMapping(path = "/{employeeId}")
    public EmployeeDTO updatePartialEmployeeById(@RequestBody Map<String, Object> updates,
                                                 @PathVariable Long employeeId){
        return employeeService.updatePartialEmployeeById(updates, employeeId);
    }
}

