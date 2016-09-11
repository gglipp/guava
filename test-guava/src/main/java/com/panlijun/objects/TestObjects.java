package com.panlijun.objects;

import com.google.common.base.Objects;

public class TestObjects {
	private static final TestObjects instance = new TestObjects();
	
	public static void main(String[] args) {
		boolean testEqual = instance.testEqual(null, 1);
		System.out.println(testEqual);
	}
	//支持null比较
	public boolean testEqual(Integer a, Integer b){
		return Objects.equal(a, b);
	}
}
