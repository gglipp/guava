package com.panlijun.common.strings;

import com.google.common.base.CharMatcher;

public class TestCharMatcher {
	private static TestCharMatcher instance = new TestCharMatcher();
	
	public static void main(String[] args) {
		instance.testMatcher();
	}
	
	private void testMatcher(){
		System.out.println(CharMatcher.DIGIT.matches('4'));
		System.out.println(CharMatcher.DIGIT.matches('r'));
		System.out.println(CharMatcher.WHITESPACE.trimAndCollapseFrom("  Test   	WhiteSpac e ", '-'));
	}
}
