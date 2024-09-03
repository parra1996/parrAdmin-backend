package parrAdmin.parraAdmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import parrAdmin.parraAdmin.model.Apartment;

public interface ApartmentRepository extends JpaRepository<Apartment, Integer>{

	@Query("SELECT p FROM Apartment p WHERE p.user_id.id = :user_id")
    List<Apartment> findAllByUserId(@Param("user_id") int user_id);
	
	List<Apartment> findAllByName(@Param("name") String name);
	
	
}
