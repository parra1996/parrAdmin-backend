package parrAdmin.parraAdmin.Response;

import java.util.Optional;

import lombok.Data;
import lombok.NoArgsConstructor;
import parrAdmin.parraAdmin.model.User;

@NoArgsConstructor
@Data
public class LoginResponse {
	private String message;
	private Boolean status;
	private User user;
	
	public LoginResponse(String message,Boolean status,User user) {
		this.message = message;
		this.status = status;
		this.user = user;
	}
	
	public LoginResponse(String message,Boolean status) {
		this.message = message;
		this.status = status;
	}
	
	public LoginResponse(Boolean status,User user) {
		this.status = status;
		this.user = user;
	}
	
	public LoginResponse(Boolean status) {
		this.status = status;
	}
	
	public LoginResponse(User user) {
		this.user = user;
	}
	
	public LoginResponse(String message) {
		this.message = message;
	}
	
	
}
