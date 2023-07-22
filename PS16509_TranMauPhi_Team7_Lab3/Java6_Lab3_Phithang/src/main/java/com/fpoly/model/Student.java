package com.fpoly.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	private String fullname;
	private String email;
	private Double marks;
	private Boolean gender;
	private String country;
}
