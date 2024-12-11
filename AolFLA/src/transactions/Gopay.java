package transactions;

import main.MainMenu;
import rooms.Room;

public class Gopay extends Transaction {
	
	private String phoneNumber;

	@Override
	public void pay(Room room) {
		System.out.print("Enter your phone number: ");
		phoneNumber = MainMenu.sc.nextLine();
		
		System.out.println("\n\n");
		
		System.out.println("Price = " + room.getPrice());
		this.setTransactionId();
		transactions.add(this);
		System.out.println("Transaction ID = " + this.getTransactionId());
		
		System.out.print("Confirm payment? [Y|N]: ");
		String confirmed = MainMenu.sc.nextLine();
		super.setPaid(true);
		
		System.out.println("Payment confirmed!");
	}


}
