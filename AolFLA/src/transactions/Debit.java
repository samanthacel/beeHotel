package transactions;

import java.util.Random;

import main.MainMenu;
import rooms.Room;

public class Debit extends Transaction {
	private String virtualAccount;
	
	public static String generateVA() {
        Random random = new Random();
        StringBuilder numberBuilder = new StringBuilder();

        for (int i = 0; i < 16; i++) {
            numberBuilder.append(random.nextInt(10));

            if ((i + 1) % 4 == 0 && i != 15) {
                numberBuilder.append(" ");
            }
        }

        return numberBuilder.toString();
    }

	@Override
	public void pay(Room room) {
		virtualAccount = generateVA();
		System.out.println("Pay to this VA number : " + virtualAccount);
		
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
