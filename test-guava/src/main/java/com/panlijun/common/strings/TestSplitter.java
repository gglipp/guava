package com.panlijun.common.strings;

import com.google.common.base.Splitter;


/**
 * @author Pan Lijun
 * @date 2016年9月9日
 * 
 */
public class TestSplitter {
	
	private static final TestSplitter instance = new TestSplitter();
	
	public static void main(String[] args) {
		instance.testSplitString("1-2-3-4  -5-6---7");

	}
	
	/**
	 * @param sequence
	 * 分割String
	 */
	private void testSplitString(String sequence){
		Iterable<String> split = Splitter.on("-")
				.trimResults()
				.omitEmptyStrings()
				.split(sequence);
		System.out.println(split);
	}
	
	
	
	
}
