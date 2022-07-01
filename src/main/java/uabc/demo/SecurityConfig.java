package uabc.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import uabc.demo.services.UserService;

@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
	@Configuration
	public class SecurityConfig {
		
		@Autowired
		private UserService usuarioServicio;
		
		@Autowired
		private BCryptPasswordEncoder passwordEncoder;
		
		@Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
			http.authorizeRequests().antMatchers("/", "/assets/**").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin().loginPage("/login").defaultSuccessUrl("/index").permitAll()
			.and()
			.logout().permitAll();
			
	        return http.build();
	    }
		
		@Autowired
		public void configuraGlobal(AuthenticationManagerBuilder build) throws Exception{
			build.userDetailsService(usuarioServicio).passwordEncoder(passwordEncoder);
		}
	}

