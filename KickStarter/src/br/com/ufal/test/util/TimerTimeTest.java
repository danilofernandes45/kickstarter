package br.com.ufal.test.util;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import br.com.ufal.exception.TimerException;
import br.com.ufal.util.Timer;
import br.com.ufal.util.TimerTime;

public class TimerTimeTest {

	@Test
	public void convertDateStringTest() {
		
		Date result1 = TimerTime.convertDateString("FooTest");
		assertEquals(result1, null);
		result1 = TimerTime.convertDateString("12-13-2018");
		assertEquals(result1, null);
		result1 = TimerTime.convertDateString("30-02-2000");
		assertEquals(result1, null);
		result1 = TimerTime.convertDateString("01-01- :)");
		assertEquals(result1, null);
		
	}
	
	@Test
	public void convertTimeStringTest() {
	
		long result2 = TimerTime.convertTimeString("AnotherFooTest");
		assertEquals(result2, -1);
		result2 = TimerTime.convertTimeString("24:00:00");
		assertEquals(result2, -1);
		result2 = TimerTime.convertTimeString("01:60:70");
		assertEquals(result2, -1);
		result2 = TimerTime.convertTimeString("14:12::P");
		assertEquals(result2, -1);
		
	}
	
	public void setTest() {
		
		try {
			TimerTime result1 = new TimerTime(new Date(), 0);
			result1.set("I'm Throwing a Exception", "Now");
			fail("Fail on setTest");
		}catch(TimerException e) {
			System.out.println("That's ok");
		}
		
		
	}
	
	@Test
	public void getRemainTimeTest() {
		
		try {
			TimerTime result1 = new TimerTime(new Date(), 0);
			result1.set("12-12-2012");
			assertTrue( result1.getRemainTime() < 0 );
		}catch(TimerException e) {
			fail("Fail on getRemainTimeTest");
		}
		
	}
	
	@Test
	public void isExpiredTest() {
		
		try {
			TimerTime result1 = new TimerTime(new Date(), 0);
			result1.set("12-12-2012");
			assertTrue( result1.isExpired() );
		}catch(TimerException e) {
			fail("Fail on isExpiredTest");
		}
		
	}

}
