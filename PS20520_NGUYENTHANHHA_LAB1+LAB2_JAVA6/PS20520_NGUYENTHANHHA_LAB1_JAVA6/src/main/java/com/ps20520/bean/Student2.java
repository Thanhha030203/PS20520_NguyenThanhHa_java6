package com.ps20520.bean;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student2 {
	String name;
	Boolean gender = false;
	Double marks = 0.0;
	Contact contact;
	List<String> subject;
}
