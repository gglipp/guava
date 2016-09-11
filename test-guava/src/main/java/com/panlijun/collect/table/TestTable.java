package com.panlijun.collect.table;

import com.google.common.collect.Table;
import com.google.common.collect.TreeBasedTable;

public class TestTable {
	public static void main(String[] args) {
		Table<String, String, Integer> table = TreeBasedTable.create();
		//HashBasedTable
		
		table.put("row1", "col1", 1);
		table.put("row1", "col2", 2);
		table.put("row1", "col3", 3);
		
		table.put("row2", "col1", 4);
		table.put("row2", "col2", 5);
		table.put("row2", "col3", 6);
		
		table.put("row3", "col1", 7);
		table.put("row3", "col2", 8);
		table.put("row3", "col3", 9);
		
		System.out.println(table);
		
		System.out.println(table.row("row1"));
		
		System.out.println(table.column("col1"));
		
		System.out.println("table size is: " + table.size());
		
		System.out.println(table.cellSet());
		
		System.out.println(table.rowKeySet());
		
		System.out.println(table.values());
		
	}
}
