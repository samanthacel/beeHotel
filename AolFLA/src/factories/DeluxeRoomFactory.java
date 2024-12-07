package factories;

import rooms.DeluxeRoom;
import rooms.Room;

public class DeluxeRoomFactory extends RoomFactory {

	@Override
	public Room createRoom(String roomId, String facility, boolean availability) {
		return new DeluxeRoom(roomId, facility, availability);
	}

}
