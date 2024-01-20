package com.sipl.vehiclemanagementsystem.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.sipl.vehiclemanagementsystem.model.Vehicle;
import com.sipl.vehiclemanagementsystem.DTO.VehicleDTO;

@Mapper(componentModel = "spring")
public interface VehicleMapper {

	VehicleMapper INSTANCE = Mappers.getMapper(VehicleMapper.class);

	Vehicle mapVehicleDTOToVehicle(VehicleDTO vehicleDto);

	VehicleDTO mapVehicleToVehicleDTO(Vehicle vehicle);
}