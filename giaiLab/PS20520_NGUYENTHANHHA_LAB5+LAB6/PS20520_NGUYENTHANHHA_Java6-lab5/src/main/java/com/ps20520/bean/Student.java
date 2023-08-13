package com.ps20520.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name ="Students")
public class Student {

		@Id
		String email;
		String fullname;
		Double marks;
		Boolean gender;
		String country;
		
}
