package factories;

import rooms.Room;
import rooms.StandardRoom;

public abstract class RoomFactory {

	public Room orderRoom(String roomId, String facility, boolean availability) {
		return createRoom(roomId, facility, availability);
	}
	
	public abstract Room createRoom(String roomId, String facility, boolean availability);
}
