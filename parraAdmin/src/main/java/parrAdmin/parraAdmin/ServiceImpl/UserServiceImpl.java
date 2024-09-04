package parrAdmin.parraAdmin.ServiceImpl;

import java.util.Optional;

import org.apache.tomcat.util.openssl.openssl_h;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ch.qos.logback.classic.Logger;
import parrAdmin.parraAdmin.DTO.LoginDTO;
import parrAdmin.parraAdmin.Response.LoginResponse;
import parrAdmin.parraAdmin.Response.RegisterResponse;
import parrAdmin.parraAdmin.model.User;
import parrAdmin.parraAdmin.repository.UserRepository;
import parrAdmin.parraAdmin.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	
	@Autowired
	private UserRepository repo;
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
	
//	@Autowired
//	private PasswordEncoder passwordEncoder;
	
	
//	@Override
//	public LoginResponse login(LoginDTO login) {
//		LoginResponse response = new LoginResponse();
//		try {
//			
//			User user  = repo.findByEmail(login.getEmail());
//			
//			if ( user ==  null ) {
//				
////				response = new LoginResponse("No user found", false);
//				response.setMessage("no user found");
//				response.setStatus(false);
//			
//			}else { 
//				
//				String password = login.getPassword();
//				String email = login.getEmail();
//				Boolean isPasswordCorrect = passwordEncoder.matches(password, user.getPassword());
//				
//				if (isPasswordCorrect) {
//					
//					Optional<User> busquedaLogin = repo.findByEmailAndPassword(email, user.getPassword());
//					System.out.println(busquedaLogin.isPresent() + "BUSQUEDA LOGIN");
//					
//					if ( busquedaLogin.isPresent()) {
//						User usuarioEncontrado = busquedaLogin.get();
//						response.setMessage("login succes");
//						response.setStatus(true);
//						response.setUser( usuarioEncontrado);
//						
//					}	else {
//						response.setMessage("login failed");
//						response.setStatus(false);
//					}
//				}else {
//					response.setMessage("contraseña incorrecta");
//					response.setStatus(false);
//				}
//				
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
////			response = new LoginResponse("error al hacer login", false);
//			response.setMessage("error al hacer login");
//			response.setStatus(false);
//		}
//		
//		System.out.println(response.getMessage() + "justo antes de enviar");
//		System.out.println(response.getStatus() + "antes de envoar");
//		return response;
//	}


	@Override
	public LoginResponse findByEmail(String email) {
		User user = null;
		LoginResponse response = new LoginResponse();
		String message = "";
		try {
			 User userfound = repo.findByEmail(email);
			if ( userfound == null ) {
				message = "No user found";
//				response = new LoginResponse(message,false);
				response.setMessage(message);
				response.setStatus(false);
			}else {
				user = userfound;
				response = new LoginResponse(message,false, user);
			}
			
		} catch (Exception e) {
			e.printStackTrace(); 
			message = "Error"; 
//			response = new LoginResponse(message,false);
			response.setMessage(message);
			response.setStatus(false);
		}
		return response;
	}

	@Override
	public RegisterResponse register(User user) {
		User newUser = new User();
		RegisterResponse response = new RegisterResponse();
		
		System.out.println(user.getName());
		try {
			
		 User userEmail = 	repo.findByEmail(user.getEmail());
		 if (userEmail != null ) {
			 response.setMessage("this email already exists");
			 response.setStatus(false);
			 throw new Exception("this email already exists");
		 }else {
			 user.setRole("USER");
			 user.setPassword(encoder.encode(user.getPassword()));
			 repo.save(user);
			 if ( user.getUser_id() > 0 ) {
				 
				 response.setMessage("se ha guardado el usuario: " + user.getName());
				 response.setStatus(true);
			 } else throw new Exception("Error al registrar el usuario" + user.getName());
			 
		 }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

}
