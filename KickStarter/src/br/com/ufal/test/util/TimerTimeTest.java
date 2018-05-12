package br.com.ufal.test.util;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import br.com.ufal.util.TimerTime;

public class TimerTimeTest {

	@Test
	public void convertDateStringTest() {
		
		Date result1 = TimerTime.convertDateString("FooTest");
		assertEquals(result1, null);
		
	}
	
	@Test
	public void convertTimeStringTest() {
	
		long result2 = TimerTime.convertTimeString("AnotherFooTest");
		assertEquals(result2, -1);
		
	}

}
