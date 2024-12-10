package main;

import java.util.Scanner;
import user.User;

public class MainMenu {
    public static Scanner sc = new Scanner(System.in);
    private String name, email, password;
    private boolean user;

    public MainMenu() {
        while (true) {
            int menu = welcomeMenu();
            switch (menu) {
                case 1: {
                    if (login()) {
                        System.out.println("\n\n");
                        HotelMenu hotelMenu = new HotelMenu();
                        handleHotelMenu(hotelMenu);
                        return;
                    }
                    break;
                }
                case 2: {
                    if (!register()) {
                        System.out.println("\n\n");
                    }
                    break;
                }
                case 3: {
                    System.out.println("Thank you for using BeeHotel. Goodbye!");
                    return;
                }
                default: {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }

    public int welcomeMenu() {
        System.out.println("===========================================");
        System.out.println("            WELCOME TO BEEHOTEL");
        System.out.println("===========================================");
        System.out.println();
        System.out.println("Please login to continue...");
        System.out.println("-------------------------------------------");
        System.out.println("1. Login (If you already have an account)");
        System.out.println("2. Register (If you are a new user)");
        System.out.println("3. Exit (Exit the application)");
        System.out.println("-------------------------------------------");
        System.out.print("Enter your choice: ");
        int menu = sc.nextInt();
        sc.nextLine();
        System.out.println();
        return menu;
    }

    public boolean login() {
        System.out.println("=====================");
        System.out.println("LOGIN");
        System.out.println("=====================");
        System.out.print("Enter your email : ");
        email = sc.nextLine();
        System.out.print("Enter your password : ");
        password = sc.nextLine();
        user = User.login(email, password);
        return user;
    }

    public boolean register() {
        System.out.println("=====================");
        System.out.println("REGISTER");
        System.out.println("=====================");
        System.out.print("Enter your name : ");
        name = sc.nextLine();
        System.out.print("Enter your email : ");
        email = sc.nextLine();
        System.out.print("Enter your password : ");
        password = sc.nextLine();
        user = User.register(name, email, password);
        return user;
    }

    private void handleHotelMenu(HotelMenu hotelMenu) {
        while (true) {
            int choice = hotelMenu.hotelMenu();
            switch (choice) {
                case 1:
                    hotelMenu.displayRoomTypes();
                    break;
                case 2:
                    System.out.print("Enter Room ID to book: ");
                    String roomId = sc.nextLine();
                    System.out.print("Enter start date (dd-mm-yyyy): ");
                    String startDate = sc.nextLine();
                    System.out.print("Enter end date (dd-mm-yyyy): ");
                    String endDate = sc.nextLine();
                    System.out.print("Enter payment method [Credit|Debit|Gopay]: ");
                    String payment = sc.nextLine();
                    
                    hotelMenu.bookRoom(roomId, startDate, endDate, payment);
                    break;
                case 3:
                	hotelMenu.displayYourOrder();
                	break;
                case 4:
                    System.out.println("Returning to the main menu...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
