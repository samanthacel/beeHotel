package factories;

import rooms.Room;
import rooms.SuperiorRoom;

public class SuperiorRoomFactory extends RoomFactory {

	@Override
	public Room createRoom(String roomId, String facility, boolean availability) {
		// TODO Auto-generated method stub
		return new SuperiorRoom(roomId, facility, availability);
	}
	
}
