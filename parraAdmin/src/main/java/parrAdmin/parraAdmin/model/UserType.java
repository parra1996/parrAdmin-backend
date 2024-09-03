package parrAdmin.parraAdmin.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UserType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userType_id")
	private Long userType_id;
	
	@Column(name="type")
	private String type;
	
	public UserType(int id) {
		super();
		this.userType_id = Long.valueOf(id);
	}

}
	
