package parrAdmin.parraAdmin.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Embeddable 
@Data
//@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ApartmentPK implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="apartment_id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	public ApartmentPK(int id, String name) {
		this.id = id;
		this.name = name;
	}

}
