package model;

import inMemoryStorage.InMemoryStorage;

public class Deposit extends Transaction {
	
	public Deposit(double amount, String fromAccount, String toAccount) {
		super(amount, fromAccount, toAccount);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void updateAccount() throws Exception {
		// TODO Auto-generated method stub
		Account account = InMemoryStorage.getAccounts(this.getToAccount());
		if(account==null) {
			throw new Exception("Account ID is invalid!");
		}
		if(this.getAmount()<=0) {
			throw new Exception("Amount must be positive!");
		}
		synchronized(account) {
			account.setBalence(account.getBalence()+this.getAmount());
		}
		
	}

}
