package br.com.ufal.pledge;

public class Pledge {
	
	protected float value;
	protected String cardNumber;
	protected String cardHolderName;
	protected int monthExpiration;
	protected int yearExpiration;
	protected String securityCode;
	
	public Pledge(float value, String cardNumber, String cardHolderName, int monthExpiration, int yearExpiration, String securityCode) {
		this.value = value;
		this.cardNumber = cardNumber;
		this.cardHolderName = cardHolderName;
		this.monthExpiration = monthExpiration;
		this.yearExpiration = yearExpiration;
		this.securityCode = securityCode;
	}
	
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	public int getMonthExpiration() {
		return monthExpiration;
	}
	public void setMonthExpiration(int monthExpiration) {
		this.monthExpiration = monthExpiration;
	}
	public int getYearExpiration() {
		return yearExpiration;
	}
	public void setYearExpiration(int yearExpiration) {
		this.yearExpiration = yearExpiration;
	}
	public String getSecurityCode() {
		return securityCode;
	}
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}
	
	

}
