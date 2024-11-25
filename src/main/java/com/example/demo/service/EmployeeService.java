package com.example.demo.service;

import com.example.demo.dto.request.EmployeeRequestDto;
import com.example.demo.dto.response.EmployeeResponseDto;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    EmployeeResponseDto addEmployee(EmployeeRequestDto request);
    List<EmployeeResponseDto> getAllEmployees();
    EmployeeResponseDto getEmployeeById(Long id);
    EmployeeResponseDto partiallyUpdateEmployee(Long id, Map<String, Object> updates);
}
