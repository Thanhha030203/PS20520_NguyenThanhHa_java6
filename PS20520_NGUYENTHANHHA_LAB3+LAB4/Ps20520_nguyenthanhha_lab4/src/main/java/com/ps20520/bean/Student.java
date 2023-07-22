package com.ps20520.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	private String fullname;
	private String email;
	private Boolean gender;
	private Double marks;
	private String phone;
	private String subjects;
}
