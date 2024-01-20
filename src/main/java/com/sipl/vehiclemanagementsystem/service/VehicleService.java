package com.sipl.vehiclemanagementsystem.service;

import java.util.List;

import com.sipl.vehiclemanagementsystem.model.Vehicle;
import com.sipl.vehiclemanagementsystem.DTO.VehicleDTO;

public interface VehicleService {

	Vehicle createVehicle(VehicleDTO vehicleDto);

	Vehicle getVehicleById(Long id);

	List<Vehicle> getAllVehicle(Integer pageNumber, Integer pageSize);

	Vehicle updateVehicle(Long id, VehicleDTO vehicleDto);

	void deleteVehicle(Long id);

	String getVehicleById1();

}