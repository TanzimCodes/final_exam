package com.example.demo.dto.response;

import com.example.demo.dto.response.VehicleServiceResponseDto;

import java.time.LocalDate;
import java.util.List;

public record EmployeeResponseDto(
        Long id,
        String name,
        String email,
        String phone,
        LocalDate hireDate,
        List<VehicleServiceResponseDto> services
) {
}
