package com.panlijun.range;

import com.google.common.collect.Range;
import com.google.common.primitives.Ints;

public class TestRange {
	private static final TestRange instance = new TestRange();

	public static void main(String[] args) {
		instance.testClosed(1, 10);
	}
	
	public void testClosed(Integer lower, Integer upper){
		Range<Integer> range = Range.closed(lower, upper);
		System.out.println("closed range is: " + range);
		System.out.println("range contains 4: " + range.contains(4));
		System.out.println("range contains 1, 2, 30: " + range.containsAll(Ints.asList(1, 2, 30)));
		System.out.println("lower bound is: " + range.lowerEndpoint());
		System.out.println("upper bound is: " + range.upperEndpoint());
		Range<Integer> range2 = Range.open(lower, upper);
		System.out.println("opne range is: " + range2);
		Range<Integer> openClosed = Range.openClosed(lower, upper);
		System.out.println("open closed range is: " + openClosed);
		Range<Integer> closedOpen = Range.closedOpen(lower, upper);
		System.out.println("closed open range is: " + closedOpen);
		
		
	}
	
	

}
