package inMemoryStorage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Account;
import model.Transaction;
import model.Wallet;

public class InMemoryStorage {
	
	private static Map<String, Account> accounts = new HashMap<>();
	private static Map<String, List<Transaction>> transactions = new HashMap<>();
	private static Map<String,Wallet> wallets = new HashMap<>();
	
	
	
	
	public static Account getAccounts(String id) {
		return accounts.get(id);
	}
	
	public static void addAccount(Account account) {
		accounts.put(account.getAccountId(), account);
	}
	
	public static void addTransaction(String id, Transaction transaction) {
		if(transactions.containsKey(id)) {
			transactions.get(id).add(transaction);
		}else {
			List<Transaction> list = new ArrayList<>();
			list.add(transaction);
			transactions.put(id, list);
		}
	}
	
	public static List<Transaction> getTransactions(String account){
		return transactions.get(account);
	}
	
	public static void addWallet(Wallet wallet){
		wallets.put(wallet.getUserName(),wallet);
	}
	
	public static Wallet getWallet(String userName){
		return wallets.get(userName);
	}
	

}

