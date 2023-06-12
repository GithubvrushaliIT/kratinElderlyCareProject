package com.kratin.elderlyCareApp.service;

import java.util.List;

import com.kratin.elderlyCareApp.payload.HealthDataDto;

public interface HealthDataService {
	// create
	HealthDataDto createHealthData(HealthDataDto HealthDataDto);

	// update
	HealthDataDto updateHealthData(HealthDataDto HealthDataDto, Integer healthDataId);

	// delete
	void deleteHealthData(Integer healthDataId);

	// get
	HealthDataDto getHealthData(Integer healthDataId);

	// getall
	List<HealthDataDto> getAllHealthData();

}
