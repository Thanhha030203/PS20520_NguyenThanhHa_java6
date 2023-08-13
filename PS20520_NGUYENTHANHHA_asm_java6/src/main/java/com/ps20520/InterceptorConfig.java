package com.ps20520;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ps20520.intercepter.GlobalInterceptor;


@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
	 // Dùng để chắn các truy suất
	@Autowired
	GlobalInterceptor globalInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(globalInterceptor)
		// Interceptor sẽ chạy trong mội tình huống từ rest, admin, assets
		//Kiểu nó kiểm tra đường dẫn xem những đường dẫn này có hợp lý để nó thực hiện phương thức không
		.addPathPatterns("/**")
		.excludePathPatterns("/rest/**","/admin/**","/assets/**");
		
	}
}
