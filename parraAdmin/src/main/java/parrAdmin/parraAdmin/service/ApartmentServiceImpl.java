package parrAdmin.parraAdmin.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import parrAdmin.parraAdmin.DTO.ApartmentDTO;
import parrAdmin.parraAdmin.model.Apartment;
import parrAdmin.parraAdmin.model.ApartmentPK;
import parrAdmin.parraAdmin.model.User;
import parrAdmin.parraAdmin.repository.ApartmentRepository;

@Service
public class ApartmentServiceImpl implements ApartmentService{
	
	@Autowired
	ApartmentRepository repo;
	
	@PersistenceContext
	private EntityManager entityManager;


	@Override
	public Apartment createApartment(int user_id, String name, String direction) {
		Apartment apartamento = new Apartment();
		apartamento.setDirection(direction);
		apartamento.setName(name);
		apartamento.setUser_id(new User(user_id));
		repo.save(apartamento);
		return null;
	}


//	@Override
//	public List<Apartment> getAllApartmentsByUserID(int user_id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	 @Override
	    public List<Apartment> getAllApartmentsByUserID(int user_id) {
	        return repo.findAllByUserId(user_id);
	    }


	@Override
	public List<ApartmentDTO> getAllByName(String name) {
		
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		
		CriteriaQuery<Apartment> query = cb.createQuery(Apartment.class);
		
		Root<Apartment> root = query.from(Apartment.class);
		
		Predicate nombrePredicate = cb.equal(root.get("name"), name);
		
		query.select(root).where(nombrePredicate);
		
		List<Apartment>	apartments = entityManager.createQuery(query).getResultList();
		
		List<ApartmentDTO> apartmentDTOs =	apartments.stream().map(apartmentData -> new ApartmentDTO(apartmentData.getName(), apartmentData.getDirection())).collect(Collectors.toList());
		
		return apartmentDTOs;
	}

}
