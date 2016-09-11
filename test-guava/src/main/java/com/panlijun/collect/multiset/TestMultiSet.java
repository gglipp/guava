package com.panlijun.collect.multiset;

import java.util.Iterator;
import java.util.Set;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

public class TestMultiSet {
	
	
	public static void main(String[] args) {
		Multiset<Object> multiset = HashMultiset.create();
		multiset.add("a");
		multiset.add("a");
		multiset.add("b");
		multiset.add("b");
		multiset.add("b");
		multiset.add("c");
		multiset.add("c");
		multiset.add("c");
		multiset.add("d");
		multiset.add("c");
		multiset.add("f");
		System.out.println(multiset);
		System.out.println("length is: " + multiset.size());
		System.out.println("Occurrence of 'c': " + multiset.count("c"));
		
		Set<Object> elementSet = multiset.elementSet();
		System.out.println("set is: " + elementSet);
		
		Iterator<Object> iterator = multiset.iterator();
		System.out.print("[");
		while(iterator.hasNext()){
			System.out.print(iterator.next() + "\t");
		}
		System.out.println("]");
		
		multiset.remove("b", 2);
		System.out.println(multiset);
		
	}
}
