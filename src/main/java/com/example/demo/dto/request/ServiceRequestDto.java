package com.example.demo.dto.request;


public record ServiceRequestDto(
        Long employeeId,
        String serviceName,
        double cost,
        String vehicleType
) {
}
