package rooms;

public abstract class Room implements Cloneable {
	private String roomId;
	private String facility;
	private int price;
	private boolean availability;
	private String type;
	private String startDate, endDate;
	
	public Room(String roomId, String facility, boolean availability) {
		super();
		this.roomId = roomId;
		this.facility = facility;
		this.availability = availability;
	}
	
	@Override
    public Room clone() {
        try {
            return (Room) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning not supported for Room", e);
        }
    }
	
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	
	public void setFacility(String facility) {
		this.facility = facility;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRoomId() {
		return roomId;
	}

	public String getFacility() {
		return facility;
	}

	public int getPrice() {
		return price;
	}

	public boolean isAvailable() {
		return availability;
	}
	
	public String getType() {
		return type;
	}

	public void book(String startDate, String endDate) {
		if (availability) {
            availability = false;
            this.startDate = startDate;
            this.endDate = endDate;
            System.out.println("Room " + roomId + " has been successfully booked.");
        } else {
            System.out.println("Room " + roomId + " is not available for booking.");
        }
	}
	
	public void displayRoomDetails() {
        System.out.println("Room ID: " + roomId);
        System.out.println("Room Type: " + type);
        System.out.println("Facilities: " + facility);
        System.out.println("Price: Rp" + price + " per night");
        System.out.println("Availability: " + (availability ? "Available" : "Not Available"));
    }
	
	public static void displayAllRooms(Room[] rooms) {
		System.out.println("Room Details:");
        System.out.println("===========================================");
        for (Room room : rooms) {
            room.displayRoomDetails();
            System.out.println("-------------------------------------------");
        }
	}
	
	public void displayBookedRooms() {
		System.out.println("Room ID: " + roomId);
        System.out.println("Room Type: " + type);
        System.out.println("Facilities: " + facility);
        System.out.println("Price: Rp" + price + " per night");
        System.out.println("Booking date : "+ startDate + " until " + endDate);
	}
	
}