package br.com.ufal.user;

import java.util.Date;

import br.com.ufal.util.Address;

public class Profile {

	private String firstName;
	private String lastName;
	private Date dateBirth;
	private Address address;
	
	private BankAccount bankAccount;
	
	public Profile() {}
	
	public Profile(String firstName, Address address) {
		this.firstName = firstName;
		this.address = address;
	}

	public Profile(String firstName, String lastName, Date dateBirth, Address address, BankAccount bankAccount) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateBirth = dateBirth;
		this.address = address;
		this.bankAccount = bankAccount;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	
}
