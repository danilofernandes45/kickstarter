package br.com.ufal.util;

public class Location {

	protected String city;
	protected String country;
	
	public Location(String city, String country) {

		this.city = city;
		this.country = country;
	}

	public Location(String country) {

		this.country = country;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public String toString(){
		return ( city+", "+country );
	}
	
}
