package com.kratin.elderlyCareApp.service.iml;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kratin.elderlyCareApp.entity.HealthData;
import com.kratin.elderlyCareApp.exception.ResourceNotFoundException;
import com.kratin.elderlyCareApp.payload.HealthDataDto;
import com.kratin.elderlyCareApp.repository.HealthDataRepo;
import com.kratin.elderlyCareApp.service.HealthDataService;
@Service
public class HealthDataServiceImpl implements HealthDataService {
	@Autowired
	private HealthDataRepo HealthDataRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public HealthDataDto createHealthData(HealthDataDto HealthDataDto) {

		HealthData cat = this.modelMapper.map(HealthDataDto, HealthData.class);
		HealthData addedCat = this.HealthDataRepo.save(cat);

		return this.modelMapper.map(addedCat, HealthDataDto.class);
	}

	@Override
	public HealthDataDto updateHealthData(HealthDataDto HealthDataDto, Integer HealthDataId) {
		HealthData cat = this.HealthDataRepo.findById(HealthDataId)
				.orElseThrow(() -> new ResourceNotFoundException("HealthData", "HealthData Id", HealthDataId));
		cat.setHealthDataTitle(HealthDataDto.getHealthDataTitle());
		cat.setHealthDataDescription(HealthDataDto.getHealthDataDescription());
		HealthData updateHealthData = this.HealthDataRepo.save(cat);
		return this.modelMapper.map(updateHealthData, HealthDataDto.class);
	}

	@Override
	public void deleteHealthData(Integer HealthDataId) {
		HealthData cat = this.HealthDataRepo.findById(HealthDataId)
				.orElseThrow(() -> new ResourceNotFoundException("HealthData", "HealthData Id", HealthDataId));
		this.HealthDataRepo.delete(cat);

	}

	@Override
	public HealthDataDto getHealthData(Integer HealthDataId) {
		HealthData cat=this.HealthDataRepo.findById(HealthDataId).orElseThrow(()->new ResourceNotFoundException("HealthData", "HealthData Id", HealthDataId));
		
		return this.modelMapper.map(cat, HealthDataDto.class);
	}

	@Override
	public List<HealthDataDto> getAllHealthData() {
	List<HealthData> categories=this.HealthDataRepo.findAll();
	List<HealthDataDto> HealthDataDtoS=categories.stream().map((cat)->this.modelMapper.map(cat, HealthDataDto.class)).collect(Collectors.toList());
		return HealthDataDtoS;
	}

}
