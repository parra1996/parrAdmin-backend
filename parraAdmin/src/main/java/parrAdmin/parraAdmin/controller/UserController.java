package parrAdmin.parraAdmin.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import parrAdmin.parraAdmin.DTO.ApartmentDTO;
import parrAdmin.parraAdmin.DTO.LoginDTO;
import parrAdmin.parraAdmin.Response.LoginResponse;
import parrAdmin.parraAdmin.model.Apartment;
import parrAdmin.parraAdmin.model.User;
import parrAdmin.parraAdmin.repository.UserRepository;
import parrAdmin.parraAdmin.service.ApartmentService;
import parrAdmin.parraAdmin.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository repo;
	
	
	@Autowired
	private UserService service;
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@RequestBody LoginDTO login) {
		LoginResponse response = new LoginResponse() ;
		
		try {
			
			LoginResponse responseData =service.login(login);
			response.setMessage(responseData.getMessage());
			response.setStatus(responseData.getStatus());
			response.setUser(responseData.getUser());
			if (responseData.getStatus() == false) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
			}
			
			return ResponseEntity.ok(response);
			
		} catch (Exception e) {
			response = new LoginResponse("error",false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		
	}
	
	@GetMapping("/{email}")
	public LoginResponse getByEmail(@PathVariable String email) {
		LoginResponse response;
		
		
		try {
			User user = repo.findByEmail(email);
			if ( user == null) {
				response = new LoginResponse("no se encontro a nadie", false);
			}else {
				response = new LoginResponse("",true, user);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			response = new LoginResponse("error al buscar al pana", false);
		}
		
		return response;
		
	}
	
}
;
