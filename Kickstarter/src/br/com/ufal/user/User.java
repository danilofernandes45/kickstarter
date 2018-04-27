package br.com.ufal.user;

import java.util.Date;

import br.com.ufal.util.Address;

public class User {

	private Profile profile;
	private String email;
	private String passaword;
	private String firstName;
	private String lastName;
	private Date dateBirth;
	private Address address;
	private BankAccount bankAccount;
	
	public User(String email, String firstName, String lastName, Date dateBirth, Address address) {

		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateBirth = dateBirth;
		this.address = address;
	}

	public User(Profile profile, String email, String firstName,
			String lastName, Date dateBirth, Address address,
			BankAccount bankAccount) {

		this.profile = profile;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateBirth = dateBirth;
		this.address = address;
		this.bankAccount = bankAccount;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassaword() {
		return passaword;
	}

	public void setPassaword(String passaword) {
		this.passaword = passaword;
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