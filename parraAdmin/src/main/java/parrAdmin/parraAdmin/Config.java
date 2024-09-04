package parrAdmin.parraAdmin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.NoOp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;
import parrAdmin.parraAdmin.service.UserService;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class Config {
	
	@Autowired
	private UserDetailsService userdetail;
	
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
	
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		return http
//				.csrf(csrf -> csrf.disable())
//				.authorizeHttpRequests(auth -> 
//				auth.requestMatchers("/apartment/**").permitAll() // aqui agregamos las rutas que queremos que sean publicas, si queremos podemos poner un prefijo y generlizamos
//					.requestMatchers("/user/**").permitAll()
//					.requestMatchers("/v1").authenticated()			
////				.requestMatchers("/v1/admin").hasRole("ADMIN").anyRequest().authenticated()
//				)
////				.formLogin(Customizer.withDefaults())
//				
//				.build();
//	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		return http
				.csrf(customizer -> customizer.disable())
				.authorizeHttpRequests(request -> request.anyRequest().authenticated())
				.httpBasic(Customizer.withDefaults())
				.sessionManagement(session ->  session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.build();
	}
	
//	
//	@Bean
//	public PasswordEncoder encoder() {
//		return new BCryptPasswordEncoder();
//	}
	
//	@SuppressWarnings("deprecation")
//	@Bean
//	public UserDetailsService userDetailService()	{
//		
//		UserDetails user1 = User
//				.withDefaultPasswordEncoder()
//				.username("tete")
//				.password("tete123")
//				.roles("USER")
//				.build();
//		
//		UserDetails user2 = User
//				.withDefaultPasswordEncoder()
//				.username("cate")
//				.password("cate123")
//				.roles("USER")
//				.build();
//		
//		return new InMemoryUserDetailsManager(user1,user2);
//	}
	
	@SuppressWarnings("deprecation")
	@Bean
	public AuthenticationProvider authenticationProvider () {
		 DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		 provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		 provider.setUserDetailsService(userdetail);
		 return provider;
	}
}
