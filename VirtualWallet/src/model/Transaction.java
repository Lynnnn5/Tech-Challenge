package model;

import java.text.SimpleDateFormat;
import java.util.UUID;

public abstract class Transaction {

	private String transactionId;
	private double amount;
	private long timeStamp;
	private String fromAccount;
	private String toAccount;
	
	
	public Transaction(double amount,String fromAccount, String toAccount) {
		transactionId = UUID.randomUUID().toString(); 
		this.amount = amount;
		this.timeStamp = System.currentTimeMillis();
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
	}

	
	public abstract void updateAccount() throws Exception;


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public long getTimeStamp() {
		return timeStamp;
	}


	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	
	public String getFromAccount() {
		return fromAccount;
	}


	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}


	public String getToAccount() {
		return toAccount;
	}


	public void setToAccount(String toAccount) {
		this.toAccount = toAccount;
	}


	
	public String toString() {
		SimpleDateFormat dt = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); 
        String time = dt.format(timeStamp);
		if(fromAccount!=null&&toAccount!=null) {
			return "Transaction ID: "+transactionId+"\nTime: "+time+
					"\nStatement: Transfer $"+amount+" from account "+fromAccount+" to account "+
					toAccount;
		}
		else if(fromAccount==null) {
			return "Transaction ID: "+transactionId+"\nTime: "+time+
					"\nStatement: Deposit $"+amount+" to account "+toAccount;
		}
		
		else if(toAccount==null) {
			return "Transaction ID: "+transactionId+"\nTime: "+time+
					"\nStatement: Withdraw $"+amount+" from account "+fromAccount;
		}
		
		return "";
		
	}
	
	
}
