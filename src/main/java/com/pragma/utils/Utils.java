package com.pragma.utils;

import java.util.Random;

public class Utils {
	
	public static Integer getRandomNumber(Integer maxNumber) {
		// return a random number between 0 and maxNumber - 1
		if(maxNumber >= 1) {
			Random random = new Random();
	        return random.nextInt(maxNumber);
		}
		return 0;
		
	}
	
}
