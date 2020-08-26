package io.murad.modern.ecommerce.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import io.murad.modern.ecommerce.service.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService userService;

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		super.configure(http); 
		http
			.authorizeRequests().antMatchers("/sign-up/**", "/sign-in/**").permitAll()
			.and()
			.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN").antMatchers("/admin/**").hasRole("USER").anyRequest().authenticated()
            .and()
				.formLogin().usernameParameter("username").passwordParameter("password")
				.loginPage("/sign-in")
				.defaultSuccessUrl("/default",true)
				.failureUrl("/login.html?error=true")
				.permitAll();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder());
	}
}
