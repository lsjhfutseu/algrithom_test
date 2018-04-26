package com.test;

import org.junit.jupiter.api.Test;

public class Factorial {
	
//	public static void main(String []arc){
//		System.out.println(fac(1000));
//		//System.out.println(multi("976", "325"));
//	}

	@Test
	public void test(){
		System.out.println(fac(120));
		//System.out.println(multi("976", "325"));
	}
	public static String  fac(long i){
		if(i == 0 || i == 1)
			return "1";
		else {
			return multi(String.valueOf(i), String.valueOf(fac(i - 1)));
		}
	}
	
	public static String multi(String str1, String str2){
		int length1 = str1.length();
		int length2 = str2.length();
		
		int []verseStr1 = new int [length1];
		int []verseStr2 = new int [length2];
		int maxResultLength = (length1+1) * (length2+1);
		int []result = new int [maxResultLength];
		
		for(int i = 0; i < length1; ++i){
			verseStr1[i] = str1.charAt(length1 - i - 1) - '0';
		}
		
		for(int i = 0; i < length2; ++i){
			verseStr2[i] = str2.charAt(length2 - i - 1) - '0';
		}
		
		for(int i = 0; i < maxResultLength; ++i){
			result[i] = 0;
		}
		
		for(int j = 0; j < length2; ++j){
			for(int i = 0; i < length1; ++i){
				int temp = result[i + j] + verseStr1[i] * verseStr2[j];
				result[i + j] = temp % 10;
				int carry = temp / 10;
				result[i + j + 1] += carry;
			}
		}
		
		int resultLength = 0;
		for(int i = maxResultLength - 1; i >= 0; --i){
			if(result[i] != 0){
				resultLength = i + 1;
				break;
			}
		}
		
		String resultStr = "";
		for(int i = 0; i < resultLength; ++i){
			resultStr += result[resultLength - i - 1] + "";
		}
		return resultStr;
	}
}
