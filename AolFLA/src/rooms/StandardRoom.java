package rooms;

public class StandardRoom extends Room {

	public StandardRoom(String roomId, String facility, boolean availability) {
		super(roomId, facility, availability);
		this.setType("Standard");
		this.setPrice(700000);
	}
		
}
