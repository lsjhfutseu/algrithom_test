package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class InputTest {
	
	@Test
	public void test() {
//		Scanner scan = new Scanner(System.in);
//		System.out.print("enter a number: ");//println»»ÐÐ£»print²»»»ÐÐ
//		int number1 = scan.nextInt();
//		int number2 = scan.nextInt();
//		System.out.print(number1);
//		System.out.print(number2);
		StringBuffer str = new StringBuffer("hello world ");
		StringBuffer result = new StringBuffer();
        for(int i = 0; i < str.length(); ++i){
            if(str.charAt(i) == ' ')
                result.append("%20");
            else
                result.append(str.charAt(i));
        }
        System.out.println(result.toString());
        List list = new ArrayList(); 
        
	}
}
