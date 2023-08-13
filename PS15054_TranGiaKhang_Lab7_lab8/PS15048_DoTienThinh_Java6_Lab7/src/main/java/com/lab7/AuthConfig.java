package com.lab7;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.session.SessionManagementFilter;


import com.lab7.filter.CorsFilter;
import com.lab7.service.UserService;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class AuthConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	UserService userDetail;
	@Bean
	CorsFilter corsFilter() {
		CorsFilter filter = new CorsFilter();
		return filter;
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {	
		httpSecurity.addFilterBefore(corsFilter(), SessionManagementFilter.class);
		httpSecurity.csrf().disable();
		httpSecurity.authorizeRequests()
		//Demo bảo mật User, admin ,guest
		.antMatchers("/home/admin").hasRole("ADMIN")
		.antMatchers("/home/user").hasAnyRole("ADMIN", "USER")
		.antMatchers("/home/authenticated").authenticated()
		.antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
		.antMatchers("/rest/authorities","/rest/authorities/**").hasAnyRole("ADMIN","USER")
		.anyRequest().permitAll();

		httpSecurity.exceptionHandling().accessDeniedPage("/auth/login/denied");
		//Demo Bảo mật REST api thì dùng cái này
		httpSecurity.httpBasic();
		// Token API: dXNlcjE6MTIz
		
		//Demom Bảo mật USER, ADMIN, GUEST dùng cái này 
		httpSecurity.formLogin()
		.loginPage("/auth/login/form")
		.loginProcessingUrl("/auth/login")
		.defaultSuccessUrl("/auth/login/success", false)
		.failureUrl("/auth/login/error")
		.usernameParameter("username").passwordParameter("password");
		
	httpSecurity.oauth2Login()
		.defaultSuccessUrl("/oauth2/login/success", true)
		.failureUrl("/auth/login/error")
	.authorizationEndpoint()
		.baseUri("/oauth2/authorization");
		
	httpSecurity.rememberMe().rememberMeParameter("remember");

	httpSecurity.logout()
	.logoutUrl("/auth/logout")
	.logoutSuccessUrl("/auth/logout/success");

	}

	@Override
	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(userDetail);
	}
}
