package com.sam.demo.util;

import java.util.concurrent.TimeUnit;

public class SleepUtility {
	
	public static void sleep() {
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {

		}
	}

}
