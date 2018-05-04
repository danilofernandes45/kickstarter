package br.com.ufal.reward;

import java.util.Date;

public class LimitAvailable {

	private int banckerAmount;
	private int banckerLimit;
	private Date timeStart;
	private Date timeEnd;
	
	public LimitAvailable(int banckerLimit, Date timeStart, Date timeEnd) {

		this.banckerLimit = banckerLimit;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
	}
	
	public void increaseBanckerAmount(){
		banckerAmount++;
	}
	
	public int getBanckerLimit() {
		return banckerLimit;
	}
	public void setBanckerLimit(int banckerLimit) {
		this.banckerLimit = banckerLimit;
	}
	public Date getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(Date timeStart) {
		this.timeStart = timeStart;
	}
	public Date getTimeEnd() {
		return timeEnd;
	}
	public void setTimeEnd(Date timeEnd) {
		this.timeEnd = timeEnd;
	}	
	
	public boolean isAvailable(){
		
		Date actual = new Date();
		if( ( banckerLimit - banckerAmount ) > 0 && actual.after(timeStart) && actual.before(timeEnd))
			return true;
		
		return false;
		
	}
	
	public String toString(){
		
		if(isAvailable()){
			
			return "Quantidade disponível: "+( banckerLimit - banckerAmount )+"\n" +
					"Disponivel até: "+timeEnd;
			
		}
		
		return "Indiponível";
		
	}
	
}
