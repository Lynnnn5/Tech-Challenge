package model;

import java.util.List;

import inMemoryStorage.InMemoryStorage;

public class Bank {
	
	
	/**
	 * Create a new wallet for a user
	 * @param userName
	 * @return a wallet with two default accounts
	 * @throws Exception: if a user name already exists
	 */
	public static Wallet createWallet(String userName) throws Exception {
		if(InMemoryStorage.getWallet(userName)!=null) {
			throw new Exception("User name already exists");
		}
		Wallet w = new Wallet(userName);
		InMemoryStorage.addWallet(w);
		return w;
	}
	
	/**
	 * Return current account
	 * @param accNum
	 * @return current account
	 */
	public static Account getAccount(String accNum) {
		return InMemoryStorage.getAccounts(accNum);
	}
	
	/**
	 * Perform a withdrawal transaction on an account, and save this transaction
	 * @param amount 
	 * @param from
	 * @return a transaction
	 * @throws Exception
	 */
	public static Transaction withdraw(double amount, String from) throws Exception {
		Transaction t= new Withdraw(amount,from,null); 
		t.updateAccount();
		InMemoryStorage.addTransaction(from,t);
		return t;
	}
	
	/**
	 * Perform a deposit transaction on an account, and save this transaction
	 * @param amount
	 * @param to
	 * @return
	 * @throws Exception
	 */
	public static Transaction deposit(double amount, String to) throws Exception {
		Transaction t= new Deposit(amount,null,to); 
		t.updateAccount();
		InMemoryStorage.addTransaction(to,t);
		return t;
	}
	
	/**
	 * Perform a transfer from one account to another account, and save this transaction
	 * @param amount
	 * @param from
	 * @param to
	 * @return
	 * @throws Exception
	 */
	public static Transaction transfer(double amount, String from, String to) throws Exception {
		Transaction t= new Transfer(amount,from,to); 
		t.updateAccount();
		InMemoryStorage.addTransaction(from,t);
		InMemoryStorage.addTransaction(to,t);
		return t;
	}
	
	/**
	 * Return all transactions for an account
	 * @param accNum
	 * @return
	 */
	public static List<Transaction> getTransactions(String accNum){
		return InMemoryStorage.getTransactions(accNum);
	}
	
	/**
	 * Return Wallet for a userName
	 * @param userName
	 * @return
	 * @throws Exception "No such user"
	 */
	public static Wallet getWallet(String userName) throws Exception {
		if(InMemoryStorage.getWallet(userName)==null) {
			throw new Exception("No such user!");
		}
		return InMemoryStorage.getWallet(userName);
	}


}
