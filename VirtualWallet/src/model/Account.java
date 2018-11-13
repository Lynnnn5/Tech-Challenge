package model;

public class Account {

	private String accountId;
	private String accountName;
	private double balence;
	private static int idCreator;
	
	

	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public double getBalence() {
		return balence;
	}
	public void setBalence(double balence) {
		this.balence = balence;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	
	/**
	 * account id should be random UUID, but for easy operation at front end, I use simple integers
	 */
	public Account(String accountName) {
		accountId = ++idCreator +"";
		this.accountName = accountName;
		this.balence = 0.0;
	}
	
	
	
	

}
