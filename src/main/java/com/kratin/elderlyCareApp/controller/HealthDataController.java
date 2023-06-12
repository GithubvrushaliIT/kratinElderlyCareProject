package com.kratin.elderlyCareApp.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kratin.elderlyCareApp.payload.ApiResponse;
import com.kratin.elderlyCareApp.payload.HealthDataDto;
import com.kratin.elderlyCareApp.service.HealthDataService;

@RestController
@RequestMapping("/api/healthdata")
public class HealthDataController {
	
@Autowired
	private HealthDataService healthDataService;
	
	//create
	@PostMapping("/")
	public ResponseEntity<HealthDataDto> createHealthData(@RequestBody HealthDataDto HealthDataDto)
	{
		HealthDataDto createHealthData=this.healthDataService.createHealthData(HealthDataDto);
		return new ResponseEntity<HealthDataDto>(createHealthData,HttpStatus.CREATED);
		
	}
	//update
	@PutMapping("/{HealthDataId}")
	public ResponseEntity<HealthDataDto> updateHealthData(@RequestBody HealthDataDto HealthDataDto,@PathVariable Integer HealthDataId)
	{
		HealthDataDto updateHealthData=this.healthDataService.updateHealthData(HealthDataDto, HealthDataId);
		return new ResponseEntity<HealthDataDto>(updateHealthData,HttpStatus.OK);
		
	}
	//delete
	@DeleteMapping("/{HealthDataId}")
	public ResponseEntity<ApiResponse> deleteHealthData(@PathVariable Integer HealthDataId)
	{
		this.healthDataService.deleteHealthData(HealthDataId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("HealthData deleted successfully",true),HttpStatus.OK);
		
	}
	//get
	@GetMapping("/{HealthDataId}")
	public ResponseEntity<HealthDataDto> getHealthData(@PathVariable Integer HealthDataId)
	{
		HealthDataDto HealthDataDto=this.healthDataService.getHealthData(HealthDataId);
		return new ResponseEntity<HealthDataDto>(HealthDataDto,HttpStatus.OK);
		
	}
	
	//get all
	@GetMapping("/")
	public ResponseEntity<List<HealthDataDto>> getAllHealthData()
	{
		List<HealthDataDto>HealthDataDtos=this.healthDataService.getAllHealthData();
		return ResponseEntity.ok(HealthDataDtos);
	}
	
	
	

}
