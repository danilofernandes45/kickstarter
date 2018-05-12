package br.com.ufal.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.ufal.exception.TimerException;

public class TimerTime implements Timer{

	private static final int MILLISSECONDS = 1000;
	private static final int MILLISSECONDS_PER_HOUR = 3600*MILLISSECONDS;
	private static final int MILLISSECONDS_PER_MIN = 60*MILLISSECONDS;
	private Date endTime;

	public TimerTime() {
		endTime = new Date();
	}
	
	public TimerTime(String date, String time) throws TimerException{	
		set(date, time);
	}
	public void set(String date, String time) throws TimerException{
		
		set(date);	
		
		long result = convertTimeString(time);
		
		if(result == -1)
			throw new TimerException();
		
		endTime.setTime( endTime.getTime() + result);
	}
	
	public void set(String date) throws TimerException{
		
		Date result = convertDateString(date);
		
		if(result == null) {
			throw new TimerException();
		}
		
        endTime = result;
		
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
	
	public static Date convertDateString(String date) {
		
		try {
			String cells[] = date.split("-");
			
			if(cells.length != 3)
				throw new Exception();
			
			Integer.parseInt(cells[0]);
			Integer.parseInt(cells[1]);
			Integer.parseInt(cells[2]);
			
			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	        df.setLenient(false);
	        Date result = df.parse(date);
	        
	        return result;
	        
		}catch(Exception e) {
			return null;
		}
		
	}
	
	public static long convertTimeString(String time) {
		
		try {
			String cells[] = time.split(":");
			
			if(cells.length != 3)
				throw new Exception();
			
			int hour = Integer.parseInt(cells[0]);
			int min = Integer.parseInt(cells[1]);
			int sec = Integer.parseInt(cells[2]);
			
			if(hour<0 || hour>23 || min<0 || min>59 || sec<0 || sec>59)
				throw new TimerException();
			
			return ( hour*MILLISSECONDS_PER_HOUR + min*MILLISSECONDS_PER_MIN + sec*MILLISSECONDS );
			
		}catch(Exception e) {
			return -1;
		}
		
	}
	
}
