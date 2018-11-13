package model;

import inMemoryStorage.InMemoryStorage;

public class Withdraw extends Transaction {
	

	
	public Withdraw(double amount, String fromAccount, String toAccount) {
		super(amount, fromAccount, toAccount);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void updateAccount() throws Exception {
		// TODO Auto-generated method stub
		Account account = InMemoryStorage.getAccounts(this.getFromAccount());
		if(account==null) {
			throw new Exception("Account ID is invalid!");
		}
		if(this.getAmount()<=0) {
			throw new Exception("Amount must be positive!");
		}
		synchronized(account) {
			if(account.getBalence()<this.getAmount()) {
				throw new Exception("This account doesn't have enough money!");
			}
			account.setBalence(account.getBalence()-this.getAmount());
		}
	}

}
