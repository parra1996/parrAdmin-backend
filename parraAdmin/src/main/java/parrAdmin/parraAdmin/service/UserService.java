package parrAdmin.parraAdmin.service;


import parrAdmin.parraAdmin.Response.LoginResponse;
import parrAdmin.parraAdmin.Response.RegisterResponse;
import parrAdmin.parraAdmin.model.User;

public interface UserService {
//	public LoginResponse login(LoginDTO login);
	
	public LoginResponse findByEmail(String email);
	
	public RegisterResponse register(User user);
	
}
