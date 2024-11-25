package com.example.demo.service.impl;


import com.example.demo.dto.request.ServiceRequestDto;
import com.example.demo.dto.response.VehicleServiceResponseDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.model.VService;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.VehicleServiceRepository;
import com.example.demo.service.VehicleService;
import lombok.RequiredArgsConstructor;


@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleServiceRepository vehicleServiceRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public VehicleServiceResponseDto assignService(ServiceRequestDto request) {
        // Write your code here
        Employee employee = employeeRepository.findById(request.employeeId())
                .orElseThrow(()-> new ResourceNotFoundException(String.format("Employee with id %s not found",request.employeeId())));
        VService vService = new VService(request.serviceName(), request.cost(), request.vehicleType(),employee);
        return  mapToVehicleReposeDTO(vehicleServiceRepository.save(vService));
    }
    private VehicleServiceResponseDto mapToVehicleReposeDTO(VService vService){
       return new VehicleServiceResponseDto(
                vService.getId(), vService.getServiceName(), vService.getCost(), vService.getVehicleType()
        );
    }
}
