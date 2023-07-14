package com.ps20520.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
	String name;
	Boolean gender = false;
	Double marks = 0.0;
	
}
