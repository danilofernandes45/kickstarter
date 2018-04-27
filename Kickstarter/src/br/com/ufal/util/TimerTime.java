package br.com.ufal.util;

import java.util.Date;

public class TimerTime implements Timer{

	private Date endTime;

	public TimerTime(Date endTime) {
		this.endTime = endTime;
	}
	
	@Override
	public long getRemainTime() {
		
		Date actual = new Date();
		long remainTime = endTime.getTime() - actual.getTime();
		
		return remainTime;
	}

	@Override
	public boolean isExpired() {
		
		return ( getRemainTime() <= 0 );
		
	}
	
	
	
}
