package com.kratin.elderlyCareApp.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HealthDataDto {

	private Integer healthDataId;
	private String healthDataTitle;
	private String healthDataDescription;
	
}
