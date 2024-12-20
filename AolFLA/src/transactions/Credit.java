package transactions;

import main.MainMenu;
import rooms.Room;

public class Credit extends Transaction {
	
	private String cardNumber;
	private String cvc;
	private String expDate;
	
	@Override
	public void pay(Room room) {
		System.out.print("Enter your card number [16 digits]: ");
		cardNumber = MainMenu.sc.nextLine();
		System.out.print("Enter cvc [3 digits]: ");
		cvc = MainMenu.sc.nextLine();
		System.out.print("Enter exp date [mm/yy]: ");
		expDate = MainMenu.sc.nextLine();
		
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
