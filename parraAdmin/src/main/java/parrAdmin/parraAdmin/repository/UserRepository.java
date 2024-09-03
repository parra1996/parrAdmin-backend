package parrAdmin.parraAdmin.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import parrAdmin.parraAdmin.model.User;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	User  findByUsername(String username);
	
	User findByEmail(String email);
	
	Optional<User> findByEmailAndPassword(String email, String password);
	
}
