package com.ps20520.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ps20520.configuration.service.UserService;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AuthConfig extends WebSecurityConfigurerAdapter{
		
		@Autowired
		UserService userService;
	@Autowired
	BCryptPasswordEncoder pe;
		//Mã hoá mật khẩu
		@Bean
		public static BCryptPasswordEncoder getPasswordEncoder() { 
			return new BCryptPasswordEncoder();
			}
		
		//Quản lý người dữ liệu người sử dụng
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception { 
			auth.userDetailsService(userService);
//			auth.inMemoryAuthentication()
//			.withUser("user1").password(pe.encode("123")).roles("GUEST")
//			.and()
//			.withUser("user2").password(pe.encode("123")).roles("USER","GUEST")
//			.and()
//			.withUser("user3").password(pe.encode("123")).roles("ADMIN","USER","GUEST");
				
			
		}
		
		@Override
		protected void configure(HttpSecurity http) throws Exception { 
			//CSRF, CORS
			http.csrf().disable().cors().disable();
			
			http.authorizeRequests()
			.antMatchers("/rest/a","/rest/a/**").hasAnyRole("ADMIN","USER")
			.anyRequest().permitAll();
			
			http.httpBasic();
			
			
//			http.authorizeRequests()
//			.anyRequest().permitAll();
			// phân quyền sử dụng
//			http.authorizeRequests()
//			 // cho phép mọi đói tượng vào trang chính mà không cần đăng nhập
//			.antMatchers("/home/index","/auth/login/**").permitAll()
//			//Bắt buộc những trang request khác pải đăng nhập
//			.anyRequest().authenticated();
			
			
			//Giao diện đăng nhập nếu buộc phải đăng nhập
			//http.httpBasic();// đây là trang do trình duyệt tự tạo
			
			//Tự tạo form đăng nhập do mình làm
//			http.formLogin()
//			.loginPage("/auth/login/form") // địa chỉ dẫn đến form login khai ở Controller
//			.loginProcessingUrl("/auth/login")// địa chỉ xử lí form đăng nhập sau khi điền thông tin
//			//false ở đây là khi đăng nhập thành công không nhất thiết là về đường dẫn cho sẵn
//			.defaultSuccessUrl("/auth/login/success", false)// khi đăng nhâp thành công đãn đến đường dẫn nào
//			.failureUrl("/auth/login/error")// khi đăng nhập thất bại thì về đường dẫn nào
//			.usernameParameter("username")// tham số username tương ứng để kiểm tra
//			.passwordParameter("password");// tham số password tương ứng để kiểm tra
//			
//			http.rememberMe()
//			// ở đây nếu không khai báo tham số remember thì sẽ mặc định là remember-me
//			.rememberMeParameter("remember");
//			
//			http.logout()
//			// Ở đây logout hệ thống tự động logout cho mình không cần phải lập trình
//			.logoutUrl("/auth/logoff")// đường dẫn khi nhấn muốn đăng xuất [[logout]]
//			.logoutSuccessUrl("/auth/logoff/success");// đường dẫn trả về khi đăng xuất thành công
			
			//Phân quyền sử dụng
//			http.authorizeRequests()
//			//đường dẫn home.admin chỉ có admin mới vào đc
//			.antMatchers("/home/admins").hasRole("ADMIN")
//			//đường dẫn home/user thì cho phép admin/ user vào đc
//			.antMatchers("/home/users").hasAnyRole("ADMIN","USER")
//			//đường dẫn home/authenticated thì cho phép nguòi đã đăng nhập vào đc
//			.antMatchers("/home/authenticated").authenticated()
//			// Những cái còn lại cho phéo truy cập
//			.anyRequest().permitAll();
			
			//Đăng nhập từ mạng xá hội
			http.oauth2Login()
			.loginPage("/auth/login/form")
			.defaultSuccessUrl("/oauth2/login/success",true)
			.failureUrl("/auth/login/error")
			.authorizationEndpoint()
			.baseUri("/oauth2/authorization");
		
			
			//Điều khiển lỗi truy cập không đúng vai trò
			http.exceptionHandling()
			.accessDeniedPage("/auth/access/denied");// [[error]]
		}
		
//tạo loginProcessingUrl và logoutUrl ta sẽ không cần code hệ thống tự làm
		
		
	
}
