package com.xkcoding.logback.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @date 2019/9/14 13:54
 * @auther wangbo
 */
public class MyApp2 {
	static final Logger logger = LoggerFactory.getLogger(MyApp2.class);

	public static void main(String[] args) {
		logger.info("Entering application.");
		Books books = new Books();
		books.add("name");
		logger.info("Exiting application.");
	}
}
