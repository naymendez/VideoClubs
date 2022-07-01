package uabc.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;

@Controller
	public class MvcConfic {
		
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
			}

	}
