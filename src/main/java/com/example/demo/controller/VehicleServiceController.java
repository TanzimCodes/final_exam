package com.example.demo.controller;


import com.example.demo.dto.request.ServiceRequestDto;
import com.example.demo.dto.response.VehicleServiceResponseDto;
import com.example.demo.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/services")
@RequiredArgsConstructor
public class VehicleServiceController {
    
    private final VehicleService vehicleService;

    // Assign a service to an employee
    @PostMapping
    public ResponseEntity<VehicleServiceResponseDto> assignService(@RequestBody ServiceRequestDto request) {
        // Write your code here

        return ResponseEntity.ok(vehicleService.assignService(request));
    }
    
}
