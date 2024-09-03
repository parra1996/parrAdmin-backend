package parrAdmin.parraAdmin.service;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import parrAdmin.parraAdmin.model.User;
import parrAdmin.parraAdmin.model.UserSecurity;
import parrAdmin.parraAdmin.repository.UserRepository;


@Service
@AllArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {
	
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.err.println(username + " USERRRRRRRRRRRRRRR");
		User user = userRepository.findByUsername(username);
		if (user == null) {
			System.out.println("entro al if");
			throw new UsernameNotFoundException("User not found");
		}
		return new UserSecurity(user);
	}
	

}
