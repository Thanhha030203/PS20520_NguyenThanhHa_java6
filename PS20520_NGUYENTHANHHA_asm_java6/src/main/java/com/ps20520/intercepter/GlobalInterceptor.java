package com.ps20520.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ps20520.service.CategoryService;


@Component
public class GlobalInterceptor implements HandlerInterceptor {
	@Autowired
	CategoryService categoryService;
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
			// Ta không thể viết nó ở Controller được bởi vì mọi controller đều đc sử dụng bơi layout
		// Viết trong post Handler mà không nên viết trong preHandler vì
		// sau khi nó thực hiện phương thức trong controller xong thò postHandler mới được thực thi
		request.setAttribute("cates", categoryService.findAll());
	}
}
