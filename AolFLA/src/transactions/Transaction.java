package transactions;

import java.util.ArrayList;

import rooms.Room;

public class Transaction implements Payment {
	protected ArrayList<Transaction> transactions = new ArrayList<>();
	private String transactionId;
	private boolean isPaid;
	private String payment;
	private static int counter = 1;
	
	public void setTransactionId(String transactionId) {
		this.transactionId = String.format("T%03d", counter++);
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}

	@Override
	public void pay(Room room) {
		// TODO Auto-generated method stub
		
	}

}
