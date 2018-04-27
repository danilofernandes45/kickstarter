package br.com.ufal.util;

public class Address extends Location {

	private String streetName;
	private String number;
	private String postalCode;
	
	public Address(String city, String country, String streetName,
			String number, String postalCode) {
		super(city, country);
		this.streetName = streetName;
		this.number = number;
		this.postalCode = postalCode;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String toString(){
		
		return (streetName+", "+number+", "+super.toString()+". Postal code: "+postalCode);
		
	}

}
