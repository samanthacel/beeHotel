package rooms;

public class DeluxeRoom extends Room {

	public DeluxeRoom(String roomId, String facility, boolean availability) {
		super(roomId, facility, availability);
		this.setType("Deluxe");
		this.setPrice(1000000);
	}

}
