package com.example.demo.controller;


import com.example.demo.dto.request.EmployeeRequestDto;
import com.example.demo.dto.response.EmployeeResponseDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    // Add a new employee
    @PostMapping
    public ResponseEntity<EmployeeResponseDto> addEmployee(@RequestBody EmployeeRequestDto request) {
        // Write your code here
        return ResponseEntity.ok(employeeService.addEmployee(request));
    }

    // Get all employees
    @GetMapping
    public ResponseEntity<List<EmployeeResponseDto>> getAllEmployees() {
        // Write your code here
        return  ResponseEntity.ok(employeeService.getAllEmployees());
    }

    // Get a specific employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDto> getEmployeeById(@PathVariable Long id) {
        // Write your code here
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    // Update partially an existing employee
    @PatchMapping("/{id}")
    public ResponseEntity<EmployeeResponseDto> partiallyUpdateEmployee(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates
    ) {
        // Write your code here

        return ResponseEntity.ok(employeeService.partiallyUpdateEmployee(id,updates));
    }
}
