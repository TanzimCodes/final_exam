package com.example.demo.dto.response;

public record VehicleServiceResponseDto(
        Long id,
        String serviceName,
        double cost,
        String vehicleType
) {
}
