package parrAdmin.parraAdmin.DTO;

import lombok.Data;

@Data
public class ApartmentDTO {
	
	private String name;
    private String direction;

    public ApartmentDTO(String name, String direction) {
        this.name = name;
        this.direction = direction;
    }

}
