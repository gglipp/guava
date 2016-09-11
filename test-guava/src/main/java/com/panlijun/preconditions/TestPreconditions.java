package com.panlijun.preconditions;

import com.google.common.base.Preconditions;

public class TestPreconditions {
	private static final TestPreconditions instance = new TestPreconditions();
	
	public static void main(String[] args) {
		try {
			instance.sqrt(-241);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			instance.sum(null, 4);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			instance.getValue(10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	//检查传参是否正确
	public double sqrt(double input) throws Exception{
		Preconditions.checkArgument(input > 0.0, "传递参数非法:负值%s.", input);
		return Math.sqrt(input);
	}
	
	//检查传参是否为null值
	public int sum (Integer a, Integer b) throws Exception{
		a = Preconditions.checkNotNull(a, "第一个参数为null");
		b = Preconditions.checkNotNull(b, "第二个参数为null");
		return a + b;
	}
	
	//检查数组下标越界
	public int getValue(int index) throws Exception{
		int[] data = {1, 2, 3, 4, 5};
		Preconditions.checkElementIndex(index, data.length);
		return 0;
	}
}
