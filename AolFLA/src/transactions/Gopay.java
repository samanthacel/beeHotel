package transactions;

import main.MainMenu;
import rooms.Room;

public class Gopay extends Transaction implements Payment {
	
	private String phoneNumber;

	@Override
	public void pay(Room room) {
		System.out.print("Enter your phone number: ");
		phoneNumber = MainMenu.sc.nextLine();
		
		Transaction gopay = new Transaction();
		transactions.add(gopay);
		System.out.println("Transaction ID = " + super.getTransactionId());
		
		System.out.print("Confirm payment? [Y|N]: ");
		String confirmed = MainMenu.sc.nextLine();
		super.setPaid(true);
		
		System.out.println("Payment confirmed!");
	}


}
