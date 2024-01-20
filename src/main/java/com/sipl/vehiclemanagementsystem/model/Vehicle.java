package com.sipl.vehiclemanagementsystem.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "vehicle")
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String vehicleRegistrationNumber;
	private String ownerName;
	private String brand;
	private LocalDate registrationExpires;
	private boolean isActive;
	private String createdBy;
	@CreationTimestamp
	private LocalDateTime creationTime;
	private String modifiedBy;
	@UpdateTimestamp
	private LocalDateTime modifiedTime;

}