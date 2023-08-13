package com.lab7.service;

import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;

import com.lab7.dao.AccountDAO;
import com.lab7.entity.Account;

@Service
public class UserService implements UserDetailsService{
	@Autowired
	AccountDAO accountDAO;
	
	@Bean
	public BCryptPasswordEncoder getBCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public UserDetails loadUserByUsername(String username) {
		try {
			Account account = accountDAO.findById(username).get();
			String password = account.getPassword();
			String[] roles = account.getAuthorities().stream()
						.map(authority -> authority.getRole().getId())
						.collect(Collectors.toList()).toArray(new String[0]);
			return User.withUsername(username)
					.password(this.getBCryptPasswordEncoder().encode(password))
					.roles(roles).build();
		} catch(Exception e) {
			e.printStackTrace();
			throw new UsernameNotFoundException(username + "Not found!");
		}
	}
	
	public void loginOAuth2(OAuth2AuthenticationToken oAuth2Token) {
		String email = oAuth2Token.getPrincipal().getAttribute("email");
		String password = Long.toHexString(System.currentTimeMillis());
		UserDetails user = User.withUsername(email)
				.password(this.getBCryptPasswordEncoder().encode(password))
				.roles("GUEST").build();
		Authentication auth = new UsernamePasswordAuthenticationToken(user, null , user.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(auth);
	}

}
