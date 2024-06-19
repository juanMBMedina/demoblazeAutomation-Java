package com.pragma.utils;

import static com.pragma.constants.Constants.NULL_VALUE;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
	
	public static Integer getRandomNumber(Integer maxNumber) {
		// return a random number between 0 and maxNumber - 1
		if(maxNumber >= 1) {
			Random random = new Random();
	        return random.nextInt(maxNumber);
		}
		return 0;	
	}
	
	public static String getDataInRegex(String strTextIn, String regExp) {
		// Return data in RegExp if have one group () !
		Pattern pattern = Pattern.compile(regExp);
		Matcher matcher = pattern.matcher(strTextIn);
		if (matcher.find() && matcher.groupCount() == 1 ) {
			return matcher.group(0);
		}
		return NULL_VALUE;
	}
	
}
