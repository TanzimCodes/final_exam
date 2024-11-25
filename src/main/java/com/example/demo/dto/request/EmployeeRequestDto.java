package com.example.demo.dto.request;

import java.time.LocalDate;

public record EmployeeRequestDto(
        String name,
        String email,
        String phone,
        LocalDate hireDate
) {
}
