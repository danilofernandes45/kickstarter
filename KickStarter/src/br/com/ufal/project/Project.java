package br.com.ufal.project;

import java.util.ArrayList;

import br.com.ufal.util.*;
import br.com.ufal.user.User;
import br.com.ufal.reward.Reward;
import br.com.ufal.pledge.Pledge;



public class Project {

	protected float totalValuePledges;
	protected String shortBlurb;
	protected String title;
	protected Location location;
	protected float fundingGoal;
	protected Timer fundingDuration;
	protected String description;
	protected String descripRisksChallenges;
	protected User creator;
	protected ArrayList<User> colaborators;
	protected ArrayList<Pledge> pledges;
	protected ArrayList<Reward> rewards;
	
	
	public Project(){
		totalValuePledges = 0;
		colaborators = new ArrayList<>();
		pledges = new ArrayList<>();
		rewards = new ArrayList<>();
	}
	
	public void copy(Project p) {
		
		shortBlurb = p.getShortBlurb();
		title = p.getTitle();
		location = p.getLocation();
		fundingGoal = p.getFundingGoal();
		fundingDuration = p.getFundingDuration();
		description = p.getDescription();
		descripRisksChallenges = p.getDescripRisksChallenges();
		creator = p.getCreator();
		colaborators = p.getColaborators();
		pledges = p.getPledges();
		rewards = p.getRewards();
		
	}
	
	
	public String getShortBlurb() {
		return shortBlurb;
	}
	public void setShortBlurb(String shortBlurb) {
		this.shortBlurb = shortBlurb;
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
	public Timer getFundingDuration() {
		return fundingDuration;
	}
	public void setFundingDuration(Timer fundingDuration) {
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
	
	public void addColaborator(User user){
		colaborators.add(user);
	}
	
	public void removeColaborator(User user){
		colaborators.remove(user);
	}
	
	public void setColaborators(ArrayList<User> colaborators) {
		this.colaborators = colaborators;
	}
	public ArrayList<Pledge> getPledges() {
		return pledges;
	}
	
	public void addPledge(Pledge pledge){
		pledges.add(pledge);
		totalValuePledges += pledge.getValue();
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
	
	public float getTotalValuePledges() {
		return totalValuePledges;
	}
	
	public String shortView() {
		
		return "Titulo: "+title+"\n"+
			   "Sinopse: "+shortBlurb+"\n";
		
	}
	
	public String toString(){
		
		return "Titulo: "+title+"\n" +
				"Criador: "+creator.getName()+"\n" +
				"Valor total das doacoes:"+getTotalValuePledges()+"[Na moeda vigente em "+location.getCountry()+"]\n" +
				"Meta: "+fundingGoal+" [Na moeda vigente em "+location.getCountry()+"]\n" +
				"Quantidade de doacoes: "+pledges.size()+"\n" +
				"Descricao: \n"+description+"\n\n";
		
	}

	public void addReward(Reward reward) {
		rewards.add(reward);
		
	}

	public void deleteReward(Reward reward) {
		rewards.remove(reward);
		
	}

	public ArrayList<Reward> getAvailableRewards() {
		
		ArrayList<Reward> rewardsAvailable = new ArrayList<>();
		
		for(Reward r : rewards) {
			if(r.getLimit().isAvailable()) {
				rewardsAvailable.add(r);
			}
		}
		
		return rewardsAvailable;
	}

}
