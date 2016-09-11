package com.panlijun.common.cache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;


/**
 * @author Pan Lijun
 * @date 2016年9月9日
 * 内存缓存使用需要考虑很多问题:
 * --并发
 * --缓存失效机制
 * --内存占用过高时缓存释放
 * --缓存命中率
 * --缓存移除
 * LocadingCache是一种本地缓存
 * 
 * ----------------------------
 * 创建方式一:cacheLoader
 */
public class TestLoadingCache {
	
	private static final TestLoadingCache instance = new TestLoadingCache();
	
	public static void main(String[] args) {
		//缓存存储最多200条数据
		LoadingCache<String, String> cacheBuilder = CacheBuilder.newBuilder()
													.concurrencyLevel(10)						//并发级别,同时写缓存的线程数
													.initialCapacity(10)						//初始容量
													.maximumSize(200)							//最大储存200条记录,超过按照LRU移除
													.recordStats()								//统计缓存命中率
													//.expireAfterAccess(5, TimeUnit.SECONDS)	连接后过期时间5seconds
													.expireAfterWrite(5, TimeUnit.SECONDS)		//写缓存后过期时间5seconds
													.removalListener(new RemovalListener<String, String>() {
														public void onRemoval(
																RemovalNotification<String, String> notification) {
															// 移除缓存通知
															System.err.println("CACHE '"
																	+ notification.getKey()
																	+ "' REMOVED!! cause is: " 
																	+ notification.getCause());
														}
													})
													.build(new CacheLoader<String, String>() {
														@Override
														public String load(String key)
																throws Exception {
															// 调用数据查询
															return instance.getFromDatabase(key);
														}
													});
		try {
			System.out.println(cacheBuilder.asMap());
			for(int i=0; i<11; i++){
				System.out.println(cacheBuilder.get("10"));//第一次从库表中查询
				TimeUnit.SECONDS.sleep(1);
			}
			System.out.println(cacheBuilder.asMap());
			cacheBuilder.refresh("10");
			System.out.println(cacheBuilder.stats().toString());//输出缓存命中情况
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public String getFromDatabase(String key){
		System.out.println("QUERY THE DATABASE!!");
		return "RETURN FROM DB: {" + key + ":value}";
	}

}
