package parrAdmin.parraAdmin.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@EqualsAndHashCode
public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="room_id")
	private int room_id;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user_id;
	
	@ManyToOne
	@JoinColumn(name="apartament_id")
	private Apartment apartment_id;
	
	@Column(name="description")
	private String description;
	
	@Column(name = "date_in")
	private Date date_in;
	
	@Column(name = "date_out")
	private Date date_out;
	

}
