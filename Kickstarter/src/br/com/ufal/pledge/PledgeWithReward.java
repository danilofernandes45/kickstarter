package br.com.ufal.pledge;

import br.com.ufal.reward.Reward;

public class PledgeWithReward extends Pledge {

	private String shipping;
	private Reward reward;
	
	public PledgeWithReward(float value, String cardNumber, String cardHolderName, int monthExpiration, int yearExpiration, String securityCode, String shipping, Reward reward) {
		super(value, cardNumber, cardHolderName, monthExpiration, yearExpiration, securityCode);
		this.shipping = shipping;
		this.reward = reward;
	}

	public String getShipping() {
		return shipping;
	}

	public void setShipping(String shipping) {
		this.shipping = shipping;
	}

	public Reward getReward() {
		return reward;
	}

	public void setReward(Reward reward) {
		this.reward = reward;
	}

}
