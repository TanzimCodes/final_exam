package com.example.demo.repository;


import com.example.demo.model.VService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleServiceRepository extends JpaRepository<VService,Long> {
}
