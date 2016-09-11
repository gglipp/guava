package com.panlijun.throwables;

import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;

public class TestThrowable {
	private static final TestThrowable instance = new TestThrowable();
	
	public static void main(String[] args) {
		try {
			instance.testThrowables();
		} catch (Exception e) {
			Throwable rootCause = Throwables.getRootCause(e);
			System.out.println(rootCause);
			String stackTraceAsString = Throwables.getStackTraceAsString(e);
			System.out.println(stackTraceAsString);
		}
	}
	
	public void testThrowables() throws InvalidInputException{
		try {
			sqrt(-5.0);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			Throwables.propagateIfInstanceOf(e, InvalidInputException.class);
			Throwables.propagate(e);
		}
	}
	
	public double sqrt(Double input) throws InvalidInputException{
		Preconditions.checkNotNull(input, "传入参数不能为空");
//		Preconditions.checkArgument(input > 0.0, "传入参数%s不能被开方.", input);
		if(input < 0.0){
			throw new InvalidInputException();
		}
		return Math.sqrt(input);
	}
	
	class InvalidInputException extends Exception{

		/**
		 * 
		 */
		private static final long serialVersionUID = -8045388767112609033L;}

}
