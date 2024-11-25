package com.example.demo.service.impl;

import com.example.demo.dto.request.EmployeeRequestDto;
import com.example.demo.dto.response.EmployeeResponseDto;
import com.example.demo.dto.response.VehicleServiceResponseDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeResponseDto addEmployee(EmployeeRequestDto request) {
        // Write your code here
        return mapToResponseDto(employeeRepository.save(mapToEmployee(request)));

    }
    private Employee mapToEmployee(EmployeeRequestDto dto){
        return new Employee(dto.name(), dto.email(), dto.phone(),dto.hireDate());
    }
    @Override
    public List<EmployeeResponseDto> getAllEmployees() {
        // Write your code here
        List<Employee> list = employeeRepository.findAll();
        return list.stream().map(this::mapToResponseDto).collect(Collectors.toList());
    }

    @Override
    public EmployeeResponseDto getEmployeeById(Long id) {
        // Write your code here
        return mapToResponseDto(employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not found with ID :"+id)));
    }

    @Override
    public EmployeeResponseDto partiallyUpdateEmployee(Long id, Map<String, Object> updates) {
        // Fetch the employee by ID or throw an exception if not found
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + id));
        ;
        // Apply each update based on the key
        updates.forEach((key, value) -> {
            switch (key) {
                case "name":
                    // Write your code here
                    employee.setName(String.valueOf(value));
                    break;
                case "email":
                    // Write your code here
                    employee.setEmail(String.valueOf(value));
                    break;
                case "phone":
                    // Write your code here
                    employee.setPhone(String.valueOf(value));
                    break;
                case "hireDate":
                    // Write your code here
                    employee.setHireDate((LocalDate.parse(String.valueOf(value))));
                    break;
                default:
                    throw new IllegalArgumentException("Invalid field: " + key);
            }
        });
        // Write your code here
        return mapToResponseDto(employeeRepository.save(employee));

    }

    private EmployeeResponseDto mapToResponseDto(Employee employee) {
        List<VehicleServiceResponseDto> serviceDtos = employee.getVServices().stream()
                .map(service -> new VehicleServiceResponseDto(
                        service.getId(),
                        service.getServiceName(),
                        service.getCost(),
                        service.getVehicleType()
                )).toList();

        return new EmployeeResponseDto(
                employee.getId(),
                employee.getName(),
                employee.getEmail(),
                employee.getPhone(),
                employee.getHireDate(),
                serviceDtos
        );
    }
}
