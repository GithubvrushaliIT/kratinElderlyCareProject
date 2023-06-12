package com.kratin.elderlyCareApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kratin.elderlyCareApp.entity.HealthData;

public interface HealthDataRepo extends JpaRepository<HealthData, Integer> {

}
