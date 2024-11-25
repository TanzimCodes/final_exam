package com.example.demo.service;

import com.example.demo.dto.request.ServiceRequestDto;
import com.example.demo.dto.response.VehicleServiceResponseDto;

public interface VehicleService {
    VehicleServiceResponseDto assignService(ServiceRequestDto request);
}
