package com.panlijun.collect.bimap;

import java.util.Set;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class TestBimap {
	
	public static void main(String[] args) {
		BiMap<Integer,String> biMap = HashBiMap.create();
		
		biMap.put(1, "panlijun");
		biMap.put(2, "panjunnan");
		biMap.put(3, "panlina");
		System.out.println(biMap);
		
		System.out.println(biMap.get(2));
		
		System.out.println(biMap.inverse().get("panlina"));
		
		Set<String> values = biMap.values();
		System.out.println(values);
		
		Set<Integer> values2 = biMap.inverse().values();
		System.out.println(values2);
	}
}
