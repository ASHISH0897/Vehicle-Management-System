package com.sipl.vehiclemanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sipl.vehiclemanagementsystem.model.Vehicle;
import com.sipl.vehiclemanagementsystem.mapper.VehicleMapper;
import com.sipl.vehiclemanagementsystem.service.VehicleService;
import com.sipl.vehiclemanagementsystem.DTO.VehicleDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;
	@Autowired
	private VehicleMapper vehicleMapper;

	@PostMapping("/addVehicle")
	public ResponseEntity<Vehicle> saveVehicle(@Valid @RequestBody VehicleDTO VehicleDTO) {
		return new ResponseEntity<Vehicle>(vehicleService.createVehicle(VehicleDTO), HttpStatus.CREATED);
	}

	@GetMapping("/getVehicle/{id}")
	public ResponseEntity<Vehicle> getVehicle(@PathVariable("id") long id) {
		return new ResponseEntity<Vehicle>(vehicleService.getVehicleById(id), HttpStatus.OK);
	}

	@GetMapping("/getVehicles")
	public ResponseEntity<List<Vehicle>> getVehicle(
			@RequestParam(value = "pageNumber",defaultValue = "10", required = false) Integer pageNumber,
			@RequestParam(value = "pageSize",defaultValue = "1", required = false) Integer pageSize
			) {
		return new ResponseEntity<List<Vehicle>>(vehicleService.getAllVehicle(pageNumber, pageSize), HttpStatus.OK);
	}
	
	@GetMapping("/getVehicle/RestTemplate/{id")
	public ResponseEntity<Vehicle> getVehicleRestTemplate(@PathVariable("id") long id) {
		return new ResponseEntity<Vehicle>(HttpStatus.OK);
	}
	
//	@GetMapping("/getvehicletemp")
//	public String getVehicleTemp() {
//
//		return vehicleService.getVehiclebyTemplet();
//	}
//	

	@PutMapping("/updateVehicle/{id}")
	public ResponseEntity<Vehicle> editVehicle(@Valid @PathVariable("id") long id, @RequestBody VehicleDTO VehicleDTO,
			Vehicle vehicle) {
		return new ResponseEntity<Vehicle>(vehicleService.updateVehicle(id, VehicleDTO), HttpStatus.OK);
	}

	@DeleteMapping("/deleteVehicle/{id}")
	public ResponseEntity<String> deleteVehicle(@PathVariable("id") long id) {
		vehicleService.deleteVehicle(id);
		return new ResponseEntity<String>("Deleted successfully", HttpStatus.OK);
	}
}