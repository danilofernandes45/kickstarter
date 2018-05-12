package br.com.ufal.reward;

import java.util.Date;

public class Reward {
	
	private String title;
	private float valueDonation;
	private String description;
	private Date estimatedDelivery;
	private Shipping shippingDetails;
	private LimitAvailable limit;
	
	public Reward() {}
	
	public Reward(String title, float valueDonation, String description,
			Date estimatedDelivery, Shipping shippingDetails,
			LimitAvailable limit) {
		
		this.title = title;
		this.valueDonation = valueDonation;
		this.description = description;
		this.estimatedDelivery = estimatedDelivery;
		this.shippingDetails = shippingDetails;
		this.limit = limit;
		
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public float getValueDonation() {
		return valueDonation;
	}
	public void setValueDonation(float valueDonation) {
		this.valueDonation = valueDonation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getEstimatedDelivery() {
		return estimatedDelivery;
	}
	public void setEstimatedDelivery(Date estimatedDelivery) {
		this.estimatedDelivery = estimatedDelivery;
	}
	public Shipping getShippingDetails() {
		return shippingDetails;
	}
	public void setShippingDetails(Shipping shippingDetails) {
		this.shippingDetails = shippingDetails;
	}
	public LimitAvailable getLimit() {
		return limit;
	}
	public void setLimit(LimitAvailable limit) {
		this.limit = limit;
	}
	
	public void increaseBanckerAmount(){
		limit.increaseBanckerAmount();
	}
	
	public String toString(){
		
		return "Titulo: "+title+"\n" +
				"Valor mínimo de doaçao: "+valueDonation+"\n" +
				"Descricao: \n"+description+"\n"+
				"Data estimada para entrega: "+estimatedDelivery+"\n" +
				"Disponibilidade:\n"+getAvailablity()+"\n";
		
	}
	private String getAvailablity() {
		
		if(limit.isAvailable()){
			
			return limit.toString()+"\n"+shippingDetails;
			
		}
		
		return limit.toString();
		
	}
		
	
}
