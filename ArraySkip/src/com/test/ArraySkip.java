package com.test;

import javax.print.StreamPrintService;

import org.junit.jupiter.api.Test;

public class ArraySkip {

	//自底向上
	public int[] returnLeastSteps(int []a) {
		
		int []steps = new int[a.length];
		steps[0] = 0;
		for(int i = 1; i < a.length; ++i) {
			steps[i] = Integer.MAX_VALUE;
		}
 		for(int j = 0; j < a.length; ++j) {
			for(int i = 0; i < j; ++i) {
				if((i + a[i]) >= j && steps[j] > steps[i] + 1)
					steps[j] = steps[i] + 1;
			}
		}
		return steps;
	}
	
	//带备忘录自顶向下
	public int LeastStepsTopToBottom(int []steps, int []a, int i) {
		if(steps[i] < Integer.MAX_VALUE)
			return steps[i];
		if(i == 0) {
			steps[i] = 0;
			//return steps[i];
		}
		else if(i == 1) {
			steps[i] = 1;
			//return steps[i];
		}
		else {
			for(int k = 0; k < i; ++k) {
				int q = LeastStepsTopToBottom(steps, a, k);
				if(q + 1 < steps[i] && k + a[k] >= i)
					steps[i] = q + 1;
			}
		}
		return steps[i];
	}
	
	@Test
	public void test() {
		int[] a = {2,3,4,1,4,8,6,4,4,3,2,4,5,6,2,1,5,2,3,2,6};
		int []steps = new int[a.length];
		for(int j = 0; j < a.length; ++j) {
			steps[j] = Integer.MAX_VALUE;
		}
		System.out.println(LeastStepsTopToBottom(steps, a, a.length-1));
		a = returnLeastSteps(a);
		for(int i = 0; i < a.length; ++i) {
			System.out.println(a[i]);
		}
	}
}
