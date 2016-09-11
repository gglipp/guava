package com.panlijun.common.strings;

import java.util.ArrayList;

import com.google.common.base.Joiner;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;

/**
 * @author Pan Lijun
 * @date 2016年9月9日
 * 
 */
public class TestJoiner {
	
	private static final TestJoiner instance = new TestJoiner();
	private static ArrayList<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6, null, 7, 8, 9);
	
	public static void main(String[] args) {
		instance.testJoinList();
		instance.testJoinVarargs();
		instance.testJoinMap();
		instance.testJoinAppend();
	}
	
	/**
	 * 连接list
	 */
	private void testJoinList(){
		String join = Joiner.on("--")
				.skipNulls()
				.join(list);
		System.out.println(join);
	}
	
	/**
	 * 连接可变长参数
	 */
	private void testJoinVarargs(){
		String join = Joiner.on("~")
				.useForNull("0")
				.join(1,2,3,4,5,6,null,8,9);
		System.out.println(join);
	}
	
	/**
	 * 连接Map
	 */
	private void testJoinMap(){
		ArrayListMultimap<String, String> multimap = ArrayListMultimap.create();
		multimap.put("name", "panlijun");
		multimap.put("age", "22");
		multimap.put("gender", "male");
		String join = Joiner.on("---")
				.withKeyValueSeparator(":")
				.join(multimap.asMap());
		System.out.println(join);
	}
	
	/**
	 * appendTo测试
	 */
	private void testJoinAppend(){
		StringBuilder sb = new StringBuilder();
		sb.append("a").append("b");
		StringBuilder appendTo = Joiner.on("-")
				.appendTo(sb,"c","d","e","f");
		System.out.println(appendTo.toString());
	}
	
}
