package rooms;

public class SuperiorRoom extends Room {

	public SuperiorRoom(String roomId, String facility, boolean availability) {
		super(roomId, facility, availability);
		this.setType("Superior");
		this.setPrice(500000);
	}
	
}
