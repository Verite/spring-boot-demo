package com.xkcoding.logback.config;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * <p class="detail"> * 功能: 内存书架 * </p> * * @author Moore * @ClassName Books. * @Version V1.0. * @date 2019.12.10 14:00:13
 */
public class Books {
	final Map<Integer, String> map = new ConcurrentHashMap<>();

	/**
	 * <p class="detail"> * 功能: 存书，并返回书的id * </p> * * @param title : * @return int * @author Moore * @date 2019.12.10 14:00:16
	 */
	int add(String title) {
		final Integer next = this.map.size() + 1;
		this.map.put(next, title);
		return next;
	}

	/**
	 * <p class="detail"> * 功能: 根据书的id读取书名 * </p> * * @param id : * @return string * @author Moore * @date 2019.12.10 14:00:16
	 */
	String title(int id) {
		return this.map.get(id);
	}
}
