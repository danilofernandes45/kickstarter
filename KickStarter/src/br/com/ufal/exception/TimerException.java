package br.com.ufal.exception;

public class TimerException extends Exception{
	
	public TimerException() { super(); }
	public TimerException(String message) { super(message); }
	public TimerException(String message, Throwable cause) { super(message, cause); }
	public TimerException(Throwable cause) { super(cause); }
	
	
}
