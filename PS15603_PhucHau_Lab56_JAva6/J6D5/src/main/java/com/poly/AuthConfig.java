package com.poly;

import com.poly.untils.CustomAuthorizationRequestResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.IdTokenClaimNames;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AuthConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    private ClientRegistrationRepository clientRegistrationRepository;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);

//        auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
//                .withUser("user").password("123").roles("USER")
//                .and()
//                .passwordEncoder(NoOpPasswordEncoder.getInstance()).withUser("admin").password("123").roles("ADMIN")
//                .and()
//                .passwordEncoder(NoOpPasswordEncoder.getInstance()).withUser("guest").password("123").roles("GUEST");

    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().cors().disable();

//        http.authorizeRequests().antMatchers(new String[]{"/home/index","/home/about","/assets/**","/auth/**","/api/**"}).permitAll().anyRequest().authenticated();

        // cho phep tat ca
//        http.authorizeRequests().anyRequest().permitAll();
        // phan quyen

        http.authorizeRequests()
                .antMatchers("/home/admin").hasRole("ADMIN")
                .antMatchers("/home/user").hasAnyRole("ADMIN","USER")
                .antMatchers("/home/auth").authenticated()
                .anyRequest().permitAll();

        // fomr login
        http.formLogin().loginPage("/auth/login/form")
                .loginProcessingUrl("/auth/login") // post url login
                .defaultSuccessUrl("/home/index",true)
                .failureUrl("/auth/login/error")
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
                .oauth2Login().defaultSuccessUrl("/home/index",true).authorizationEndpoint()
                .authorizationRequestResolver(new CustomAuthorizationRequestResolver(
                        this.clientRegistrationRepository));

        http.rememberMe().rememberMeParameter("remember");

        // logout
        http.logout().logoutUrl("/auth/logoff").logoutSuccessUrl("/auth/login/form");

        // dieu kiem loi tru cap khong dung quyen
        http.exceptionHandling().accessDeniedPage("/auth/access/denied");
    }



}
