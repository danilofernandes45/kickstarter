package br.com.ufal.test.util;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import br.com.ufal.util.TimerDays;

public class TimerDaysTest {
	
	@Test
	public void getRemainTimeTest() {
		
		TimerDays timer = new TimerDays(new Date(), 10);
		assertTrue(timer.getRemainTime() > 0 );
		
	}
	
	@Test
	public void isExpiredTest() {
		
		TimerDays timer = new TimerDays(new Date(), 10);
		assertFalse( timer.isExpired() );
		
	}

}
