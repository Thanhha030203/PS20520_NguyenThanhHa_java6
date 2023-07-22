package com.fpoly.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentValidation {
	@NotBlank(message = "Vui lòng không bỏ trống họ và tên")
	private String fullname;
	@NotBlank(message = "Vui lòng không bỏ trống email")
	@Email(message = "Vui lòng nhập đúng định dạng Email")
	private String email;
	@NotNull(message = "Vui lòng không bỏ trống điểm")
	@Max(value = 10, message = "Vui lòng nhập điểm nhỏ hơn hoặc bằng 10")
	@PositiveOrZero(message = "Vui lòng nhập điểm lớn hơn hoặc bằng 0")
	private Double marks;
	@NotNull(message = "Vui lòng chọn gới tính")
	private Boolean gender;
	@NotBlank(message = "Vui lòng chọn quốc tịch")
	private String country;
}
