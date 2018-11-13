package model;

import inMemoryStorage.InMemoryStorage;

public class Transfer extends Transaction {

	public Transfer(double amount, String fromAccount, String toAccount) {
		super(amount, fromAccount, toAccount);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void updateAccount() throws Exception {
		// TODO Auto-generated method stub
		Account toAccount = InMemoryStorage.getAccounts(this.getToAccount());
		Account fromAccount = InMemoryStorage.getAccounts(this.getFromAccount());
		if(toAccount==null||fromAccount==null) {
			throw new Exception("Account ID is invalid!");
		}
		if(this.getAmount()<=0) {
			throw new Exception("Amount must be positive!");
		}
		if(toAccount.getAccountId().equals(fromAccount.getAccountId())) {
			throw new Exception("Cannot transfer between same account!");
		}
		synchronized(toAccount) {
			synchronized(fromAccount) {
				if(fromAccount.getBalence()<this.getAmount()) {
					throw new Exception("This account doesn't have enough money!");
				}
				fromAccount.setBalence(fromAccount.getBalence()-this.getAmount());
				toAccount.setBalence(toAccount.getBalence()+this.getAmount());
			}
		}
	}
	

}
