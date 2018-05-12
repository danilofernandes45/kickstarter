package br.com.ufal.user;

public class BankAccount {

	private String bank;
	private String account;
	private String agency;
	public BankAccount(String bank, String account, String agency) {
		super();
		this.bank = bank;
		this.account = account;
		this.agency = agency;
	}
	
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getAgency() {
		return agency;
	}
	public void setAgency(String agency) {
		this.agency = agency;
	}
	
}
