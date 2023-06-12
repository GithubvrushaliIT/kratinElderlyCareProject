package com.kratin.elderlyCareApp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

@Getter
@Setter
@NoArgsConstructor
public class HealthData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer healthDataId;
	@Column(name="title",length = 100,nullable = false)
	private String healthDataTitle;
	@Column(name="description")
	private String healthDataDescription;
	

}
