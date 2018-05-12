package br.com.ufal.reward;

import java.util.ArrayList;

public class ShippingEspecificCountries implements Shipping{

	private ArrayList<String> countries;
	
	public ShippingEspecificCountries(ArrayList<String> countries) {
		this.countries = countries;
	}
	
	public ArrayList<String> getCountries() {
		return countries;
	}

	public void setCountries(ArrayList<String> countries) {
		this.countries = countries;
	}

	public String toString(){
		
		String str = "Entrega disponivel para: ";
		return ( str.concat(String.join(", ", countries)));
		
	}
	
}
