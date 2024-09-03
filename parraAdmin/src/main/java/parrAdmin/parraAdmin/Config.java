package parrAdmin.parraAdmin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class Config {
	
//	@Bean
//	public InMemoryUserDetailsManager user() {
//		return new InMemoryUserDetailsManager(
//			User.withUsername("user")
//			.password("{noop}password")
//			.roles("USER")
//			.build(),
//			User.withUsername("admin")
//			.password("{noop}password")
//			.roles("ADMIN")
//			.build()
//				);
//	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
				.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(auth -> 
				auth.requestMatchers("/apartment/**").permitAll() // aqui agregamos las rutas que queremos que sean publicas, si queremos podemos poner un prefijo y generlizamos
					.requestMatchers("/user/**").permitAll()
					.requestMatchers("/v1").authenticated()			
//				.requestMatchers("/v1/admin").hasRole("ADMIN").anyRequest().authenticated()
				)
//				.formLogin(Customizer.withDefaults())
				
				.build();
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}
