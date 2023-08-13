package com.ps20520.configuration.service;


import java.util.stream.Collectors;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;
import com.ps20520.bean.Account;
import com.ps20520.responsitory.AccountDao;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	AccountDao accountDao;

	
	@Autowired
	BCryptPasswordEncoder pe;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
try {
	Account account = accountDao.findById(username).get();
	
	//Tạo YserDetails từ Account
	String password = account.getPassword();
	System.out.println("thành công"+ username+password);
	System.out.println("list het"+ account.getAuthority().size());
	String roles[] = account.getAuthority().stream()
			.map(au -> au.getRole().getId())
			.collect(Collectors.toList()).toArray(new String[0]);

	return User.withUsername(username)
			.password(pe.encode(password))
			.roles(roles).build();
	
} catch (Exception e) {
	System.out.println("Lỗok: "+ e);
	// TODO: handle exception
	throw new UsernameNotFoundException( username +"not found");
}
	}
	
	public void loginFormOAuth2(OAuth2AuthenticationToken oauth2) { 
		try {
			System.out.println("3kjdf");
			String email = oauth2.getPrincipal().getAttribute("email");
			System.out.println("kjdf2");
			String password = Long.toHexString(System.currentTimeMillis());
			System.out.println("kjdf1");
			UserDetails user = User.withUsername(email)
					.password(pe.encode(password))
					.roles("GUEST").build();
			System.out.println("kjdf");
			org.springframework.security.core.Authentication auth = new UsernamePasswordAuthenticationToken(email, null, user.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(auth);
		} catch (Exception e) {
			System.out.println("Lỗi 67");

			// TODO: handle exception
		}
	}

}
