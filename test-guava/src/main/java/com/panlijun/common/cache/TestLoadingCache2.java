package com.panlijun.common.cache;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;


/**
 * @author Pan Lijun
 * @date 2016年9月9日
 * 创建方式二:callable callback
 * 
 */
public class TestLoadingCache2 {
	
	private static final TestLoadingCache2 instance = new TestLoadingCache2();
	
	public static void main(String[] args) {
		Cache<String, String> cache = CacheBuilder.newBuilder().maximumSize(100).expireAfterWrite(5, TimeUnit.SECONDS).build();
		try {
			for (int i = 0; i < 10; i++) {
				String string = cache.get("key", new Callable<String>() {

					public String call() throws Exception {
						// 查询库表数据
						return instance.getFromDatabase("key");
					}
				});
				System.out.println(string);
				TimeUnit.SECONDS.sleep(1);
			}
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public String getFromDatabase(String key){
		System.out.println("QUERY THE DATABASE!!");
		return "{" + key + ":value}";
	}
}
