package parrAdmin.parraAdmin.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import parrAdmin.parraAdmin.DTO.ApartmentDTO;
import parrAdmin.parraAdmin.model.Apartment;
import parrAdmin.parraAdmin.service.ApartmentService;


@RestController
@RequestMapping("/apartment")
public class ApartmentController {
	
	@Autowired
	ApartmentService service;
	
	@PostMapping("/crear")
	public String postMethodName(@RequestBody Map<String, Object> datos) {
		String nombre = (String) datos.get("name");
		int user_id = (int) datos.get("user_id");
		String direction = (String) datos.get("direction");
		
		service.createApartment(user_id, nombre, direction);
		return "se creo al pana"	;
	}
	
	@PostMapping("/getAllByUserID")
	public List<Apartment> getAllByUser(@RequestBody int id) {
		System.out.println("idddd + " + id);
		List<Apartment> apartments;
		apartments =  service.getAllApartmentsByUserID(id);
		
		return apartments;
	}
	
	@GetMapping("/{name}")
	public List<ApartmentDTO> getByName(@PathVariable(name="name") String name) {
		List<ApartmentDTO> apartments;
		
		apartments =  service.getAllByName(name);
		
		return apartments;
	}
	
}
;