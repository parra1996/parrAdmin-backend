package parrAdmin.parraAdmin.service;

import java.util.List;

import parrAdmin.parraAdmin.DTO.ApartmentDTO;
import parrAdmin.parraAdmin.model.Apartment;

public interface ApartmentService {
	
	public Apartment createApartment(int user_id, String name, String direction);
	
	public List<Apartment> getAllApartmentsByUserID(int user_id);
	
	public List<ApartmentDTO> getAllByName(String name);

}
