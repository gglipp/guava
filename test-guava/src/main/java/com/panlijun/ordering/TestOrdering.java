package com.panlijun.ordering;

import java.util.ArrayList;
import java.util.Collections;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

public class TestOrdering {
	private static final TestOrdering instance = new TestOrdering();
	
	public static void main(String[] args) {
		instance.testNature();
		instance.testUsingToString();
	}
	//nature:自然排序
	//[null, 2, 3, 4, 54, 63, 76, 521]
	public void testNature(){
		ArrayList<Integer> numbers = Lists.newArrayList(3, 4, 521, 2, 54, 63, 76, null);
		@SuppressWarnings("rawtypes")
		Ordering<Comparable> ordering = Ordering.natural().nullsFirst();
		Collections.sort(numbers, ordering);
		System.out.println(numbers);
		Integer max = ordering.max(4, 1);
		System.out.println("max of 4,1 is:" + max);
		boolean ordered = ordering.isOrdered(numbers);
		System.out.println("numbers is sorted :" + ordered);
	}
	//null值需要用nullsFirst()/nullsLast()单独处理
	//支持链式调用,从后往前处理
	//[huangjunliang, lisi, panlijun, tiancheng, zhangqi, zhangsan, null]
	public void testUsingToString(){
		ArrayList<String> names = Lists.newArrayList("panlijun", "zhangqi", "tiancheng", "huangjunliang", null, "zhangsan", "lisi");
		Ordering<Object> ordering = Ordering.usingToString().nullsLast();
		Collections.sort(names, ordering);
		System.out.println(names);
	}
}
