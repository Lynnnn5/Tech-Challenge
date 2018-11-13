package model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import inMemoryStorage.InMemoryStorage;

public class Wallet {
	
	private String walletId;
	private String userName;
	private List<String> accounts;
	
	
	public Wallet(String userName) {
		this.userName=userName;
		walletId  =  UUID.randomUUID().toString(); 
		Account a = new Account("Spend Account");
		Account b = new Account("Growth Account");
		accounts = new ArrayList<String>();
		accounts.add(a.getAccountId());
		accounts.add(b.getAccountId());
		InMemoryStorage.addAccount(a);
		InMemoryStorage.addAccount(b);
	}


	public String getWalletId() {
		return walletId;
	}


	public void setWalletId(String walletId) {
		this.walletId = walletId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public List<String> getAccounts() {
		return accounts;
	}


	public void setAccounts(List<String> accounts) {
		this.accounts = accounts;
	}
	

}
