package br.com.ufal.project;

import java.util.ArrayList;

import br.com.ufal.util.*;
import br.com.ufal.user.User;
import br.com.ufal.reward.Reward;
import br.com.ufal.pledge.Pledge;



public class Project {

	protected String shortBlurb;
	protected String country;
	protected String title;
	protected Location location;
	protected float fundingGoal;
	protected TimerTime fundingDuration;
	protected String description;
	protected String descripRisksChallenges;
	protected User creator;
	protected ArrayList<User> colaborators;
	protected ArrayList<Pledge> pledges;
	protected ArrayList<Reward> rewards;
	
	
	public Project copy(Project p) {
		
		p.setShortBlurb(shortBlurb);
		p.setCountry(country);
		p.setTitle(title);
		p.setLocation(location);
		p.setFundingGoal(fundingGoal);
		p.setFundingDuration(fundingDuration);
		p.setDescription(description);
		p.setDescripRisksChallenges(descripRisksChallenges);
		p.setCreator(creator);
		p.setColaborators(colaborators);
		p.setPledges(pledges);
		p.setRewards(rewards);
		
		return p;
		
	}
	
	
	public String getShortBlurb() {
		return shortBlurb;
	}
	public void setShortBlurb(String shortBlurb) {
		this.shortBlurb = shortBlurb;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public float getFundingGoal() {
		return fundingGoal;
	}
	public void setFundingGoal(float fundingGoal) {
		this.fundingGoal = fundingGoal;
	}
	public TimerTime getFundingDuration() {
		return fundingDuration;
	}
	public void setFundingDuration(TimerTime fundingDuration) {
		this.fundingDuration = fundingDuration;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescripRisksChallenges() {
		return descripRisksChallenges;
	}
	public void setDescripRisksChallenges(String descripRisksChallenges) {
		this.descripRisksChallenges = descripRisksChallenges;
	}
	public User getCreator() {
		return creator;
	}
	public void setCreator(User creator) {
		this.creator = creator;
	}
	public ArrayList<User> getColaborators() {
		return colaborators;
	}
	public void setColaborators(ArrayList<User> colaborators) {
		this.colaborators = colaborators;
	}
	public ArrayList<Pledge> getPledges() {
		return pledges;
	}
	public void setPledges(ArrayList<Pledge> pledges) {
		this.pledges = pledges;
	}
	public ArrayList<Reward> getRewards() {
		return rewards;
	}
	public void setRewards(ArrayList<Reward> rewards) {
		this.rewards = rewards;
	}
	
	

}
