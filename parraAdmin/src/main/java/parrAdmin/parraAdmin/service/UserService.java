package parrAdmin.parraAdmin.service;


import parrAdmin.parraAdmin.DTO.LoginDTO;
import parrAdmin.parraAdmin.Response.LoginResponse;

public interface UserService {
	public LoginResponse login(LoginDTO login);
	
	public LoginResponse findByEmail(String email);
	
}
