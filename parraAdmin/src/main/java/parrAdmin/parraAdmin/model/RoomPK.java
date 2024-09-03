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
public class RoomPK implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@Column(name = "user_id")
	private int user_id;
	
	@Column(name="apartment_id")
	private int apartment_id;
	
	@Column(name="room_id")
	private int room_id;
	
	public RoomPK(int userID, int apartmentID, int roomId) {
		this.user_id = userID;
		this.apartment_id = apartmentID;
		this.room_id = roomId;
	}
	
}
