package com.sipl.vehiclemanagementsystem.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sipl.vehiclemanagementsystem.DTO.VehicleDTO;
import com.sipl.vehiclemanagementsystem.exceptions.VehicleNotFoundException;
import com.sipl.vehiclemanagementsystem.mapper.VehicleMapper;
import com.sipl.vehiclemanagementsystem.model.Vehicle;
import com.sipl.vehiclemanagementsystem.repository.VehicleRepository;

@Service

public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleRepository vehiclerepo;
	@Autowired
	private VehicleMapper vehicleMapper;

	@Autowired
	private RestTemplate restTemplate;

	public void VehicleService(VehicleRepository vehiclerepo) {
		this.vehiclerepo = vehiclerepo;
	}

	@Override
	public Vehicle createVehicle(VehicleDTO vehicleDto) {
		Vehicle vehicle = vehicleMapper.mapVehicleDTOToVehicle(vehicleDto);
//		if (vehiclerepo.existsByVehicleRegistrationNumber(vehicleDto.getVehicleRegistrationNumber)) {
//			throw new VehicleNotFoundException("Vehicle with this registration number already exists");
//		}
		return vehiclerepo.save(vehicle);
	}

	@Override
	public Vehicle getVehicleById(Long id) {
		return vehiclerepo.findById(id).orElseThrow(() -> new VehicleNotFoundException("Vehicle Id is not found"));
	}

	// RestTemplate
	
	@Override
//	public String getVehiclebyTemplet() {
//
//		try {
//			HttpHeaders headers = new HttpHeaders();
//			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//			HttpEntity<String> entity = new HttpEntity<String>(headers); 
//			ResponseEntity<String> templateData = restTemplate.exchange("https://jsonplaceholder.typicode.com/todos/1",
//					HttpMethod.GET, entity, String.class, headers);
//
//			return templateData.getBody();
//		} catch (Exception e) {
//
//		}
//		return null;
//	}

	public String getVehicleById1() {
		
//		HttpHeaders headers = new HttpHeaders();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>(headers);
		ResponseEntity<String> responseEntity = restTemplate.exchange("http://localhost:3000/getVehicle",
				HttpMethod.GET, entity, String.class);
		return responseEntity.getBody();
	}

//	public String getVehicleById1(Long id) {
//		HttpHeaders headers = new HttpHeaders();
//		headers.setAccept (Arrays.asList(MediaType.APPLICATION_JSON));
//		HttpEntity<String> entity = new HttpEntity<String>(headers);
//		
//		String url = "http://localhost:8080/getVehicle" + id;
//		
//		try {
//			ResponseEntity<Vehicle> responseEntity = restTemplate 
//					.exchange("http://localhost:8080/getVehicle" + id, HttpMethod.GET, entity, Vehicle.class);
//			return responseEntity.getBody();
//		} catch (Exchange e) {
//			
//			throw new VehicleNotFoundException("Error fatching information");
//		}
//	}

	// Pagination

	@Override
	public List<Vehicle> getAllVehicle(Integer pageNumber, Integer pageSize) {

		Pageable p = PageRequest.of(pageNumber, pageSize);
		List<Vehicle> vehicleList = vehiclerepo.findAll(p).toList();
		return vehicleList;
//		Pageable p=PageRequest.of(pageNumber, pageSize);
//		List<Vehicle> vehicleList = vehiclerepo.findAll(p);
//		List<Vehicle> getAllVehicle = vehicleList.();
//		return getAllVehicle;

	}

	@Override
	public Vehicle updateVehicle(Long id, VehicleDTO vehicleDto) {
		Vehicle updatedVehicle = vehiclerepo.findById(id)
				.orElseThrow(() -> new VehicleNotFoundException("Vehicle Id is not found"));
//        updateVehicle.setOwnerName(vehicleDto.getOwnerName());

		vehiclerepo.save(updatedVehicle);
		return updatedVehicle;
	}

	@Override
	public void deleteVehicle(Long id) {
		vehiclerepo.findById(id).orElseThrow(() -> new VehicleNotFoundException("Vehicle Id is not found"));
		vehiclerepo.deleteById(id);

	}

}