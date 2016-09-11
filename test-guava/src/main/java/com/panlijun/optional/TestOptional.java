package com.panlijun.optional;

import com.google.common.base.Optional;

public class TestOptional {
	private static final TestOptional instance = new TestOptional();
	private static Integer value1 = null;
	private static Integer value2 = new Integer(10);
	
	public static void main(String[] args) {
//		instance.testOf();
		instance.testFromNullable();
	}
	
	//若为null快速失败
	public void testOf(){
		Optional<Integer> optionalValue1 = Optional.of(value1);//若为null快速失败
		Optional<Integer> optionalValue2 = Optional.of(value2);
		System.out.println("optionalValue1=" + optionalValue1);
		System.out.println("optionalValue2=" + optionalValue2);
	}
	
	//若为null则为absent
	//optionalValue1=Optional.absent()
	//optionalValue1Value=0
	//optionalValue2=Optional.of(10)
	//optionalValue2Value=10
	public void testFromNullable(){
		Optional<Integer> optionalValue1 = Optional.fromNullable(value1);
		Optional<Integer> optionalValue2 = Optional.fromNullable(value2);
		System.out.println("optionalValue1=" + optionalValue1);
		System.out.println("optionalValue1Value=" + optionalValue1.or(new Integer(0)));
		System.out.println("optionalValue2=" + optionalValue2);
		System.out.println("optionalValue2Value=" + optionalValue2.or(new Integer(0)));
	}

}
