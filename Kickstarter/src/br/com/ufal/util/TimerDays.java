package br.com.ufal.util;

import java.util.Date;

public class TimerDays implements Timer{
	
	private int  amountDays;
	private long amountMilliseconds;
	private Date initialDate;
	
	public TimerDays(Date initialDate, int amountDays) {
		
		this.amountDays = amountDays;
		this.initialDate = initialDate;
		this.amountMilliseconds = convertDaysToMillisec(amountDays);
		
	}
	
	@Override
	public long getRemainTime() {
		
		Date actual = new Date();
		long passTime = actual.getTime() - initialDate.getTime();
		
		return ( amountMilliseconds - passTime );
		
		
	}
	@Override
	public boolean isExpired() {
		
		return ( getRemainTime() <= 0 );
		
	}
	
	public long convertDaysToMillisec(int amountDays) {
		
		return (amountDays * 86400000);
		
	}

	public int getAmountDays() {
		return amountDays;
	}

	public void setAmountDays(int amountDays) {
		this.amountDays = amountDays;
	}

	public long getAmountMilliseconds() {
		return amountMilliseconds;
	}

	public void setAmountMilliseconds(long amountMilliseconds) {
		this.amountMilliseconds = amountMilliseconds;
	}

	public Date getInitialDate() {
		return initialDate;
	}

	public void setInitialDate(Date initialDate) {
		this.initialDate = initialDate;
	}
	
	

}
