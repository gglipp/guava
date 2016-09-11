package com.panlijun.collect.multimap;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;

public class TestMultimap {
	
	public static void main(String[] args) {
		Multimap<String,String> multimap = ArrayListMultimap.create();
		multimap.put("name", "panlijun");
		multimap.put("gender", "male");
		multimap.put("age", "26");
		multimap.put("name", "zhangsan");
		
		Collection<String> collection = multimap.get("name");
		System.out.println(collection);
		
		List<String> list = (List<String>)collection;
		System.out.println(list);
		
		Map<String, Collection<String>> asMap = multimap.asMap();
		System.out.println(asMap);
		
		Multiset<String> keys = multimap.keys();
		System.out.println(keys);
		
		Collection<String> values = multimap.values();
		System.out.println(values);
		
		Set<String> keySet = multimap.keySet();
		System.out.println(keySet);
		
		
		
	}

}
