package factories;

import rooms.Room;
import rooms.StandardRoom;

public class StandardRoomFactory extends RoomFactory {

	@Override
	public Room createRoom(String roomId, String facility, boolean availability) {
		return new StandardRoom(roomId, facility, availability);
	}

	
}
