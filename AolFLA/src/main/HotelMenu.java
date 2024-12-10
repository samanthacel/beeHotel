package main;

import java.util.ArrayList;

import rooms.DeluxeRoom;
import rooms.Room;
import rooms.StandardRoom;
import rooms.SuperiorRoom;
import transactions.Credit;
import transactions.Debit;
import transactions.Gopay;

public class HotelMenu {
    private Room[] rooms;
    private ArrayList<Room> bookedRooms;

    public HotelMenu() {
        initiateRoomData();
        bookedRooms = new ArrayList<>();
    }

    public int hotelMenu() {
        System.out.println("===========================================");
        System.out.println("                BEEHOTEL MENU");
        System.out.println("===========================================");
        System.out.println("1. Display rooms");
        System.out.println("2. Book room");
        System.out.println("3. Display your order");
        System.out.println("4. Exit");
        System.out.println("-------------------------------------------");
        System.out.print("Enter your choice: ");
        int menu = MainMenu.sc.nextInt();
        MainMenu.sc.nextLine();
        System.out.println("\n\n");
        return menu;
    }

    private void initiateRoomData() {
    	rooms = new Room[]{
                new DeluxeRoom("D101", "King Bed, Wi-Fi, Air Conditioning", true),
                new DeluxeRoom("D102", "Queen Bed, Wi-Fi, Air Conditioning", false),
                new StandardRoom("S201", "Single Bed, Wi-Fi", true),
                new StandardRoom("S202", "Single Bed, Wi-Fi", true),
                new SuperiorRoom("SU301", "King Bed, Wi-Fi, Ocean View", true),
                new SuperiorRoom("SU302", "King Bed, Wi-Fi, Ocean View",  false)
            };
    }

    public void displayRoomTypes() {
        System.out.println("===========================================");
        System.out.println("                ROOM TYPES");
        System.out.println("===========================================");
        System.out.println("1. Deluxe");
        System.out.println("2. Standard");
        System.out.println("3. Superior");
        System.out.println("===========================================");
        System.out.print("Select room type: ");
        int choice = MainMenu.sc.nextInt();
        MainMenu.sc.nextLine();  
        System.out.println("\n\n");
        displayRoomsByType(choice);
    }

    public void bookRoom(String roomId, String startDate, String endDate, String payment) {
        for (Room room : rooms) {
            if (room.getRoomId().equalsIgnoreCase(roomId)) {
                if (!room.isAvailable()) {
                    System.out.println("Room " + roomId + " is already booked.");
                    return;
                }
                payRoom(room, payment);
                room.book(startDate, endDate);
                bookedRooms.add(room); 
                return;
            }
        }
        System.out.println("Room ID not found.");
    }

    public void payRoom(Room room, String payment) {
    	if (payment.equalsIgnoreCase("credit")) {
    		Credit credit = new Credit();
    		credit.pay(room);
    	}else if (payment.equalsIgnoreCase("debit")) {
    		Debit debit = new Debit();
    		debit.pay(room);
    	}else if (payment.equals("gopay")) {
    		Gopay gopay = new Gopay();
    		gopay.pay(room);
    	}
    }
    
    public void displayRoomsByType(int choice) {
        String selectedType = "";
        switch (choice) {
            case 1:
                selectedType = "Deluxe";
                break;
            case 2:
                selectedType = "Standard";
                break;
            case 3:
                selectedType = "Superior";
                break;
            default:
                System.out.println("Invalid selection.");
                return;
        }

        System.out.println("===========================================");
        System.out.println("               " + selectedType + " Rooms");
        System.out.println("===========================================");
        for (Room room : rooms) {
            if (room.getType().equalsIgnoreCase(selectedType)) {
                room.displayRoomDetails();
                System.out.println("-------------------------------------------");
            }
        }
    }

    public void displayYourOrder() {
        if (bookedRooms.isEmpty()) {
            System.out.println("You haven't booked any rooms yet.");
        } else {
            System.out.println("===========================================");
            System.out.println("                YOUR ORDER");
            System.out.println("===========================================");
            for (Room room : bookedRooms) {
            	room.displayBookedRooms();
                System.out.println("-------------------------------------------");
            }
        }
    }
}
