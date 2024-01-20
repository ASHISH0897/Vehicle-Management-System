package com.sipl.vehiclemanagementsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sipl.vehiclemanagementsystem.model.Vehicle;
import com.sipl.vehiclemanagementsystem.DTO.VehicleDTO;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {

	Optional<Vehicle> findById(Long id);

	void deleteById(Long id);

	Vehicle save(VehicleDTO updatedVehicle);

	boolean existsByVehicleRegistrationNumber(String vehicleRegistrationNumber);

}