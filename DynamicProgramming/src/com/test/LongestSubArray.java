package com.test;

import org.junit.jupiter.api.Test;

public class LongestSubArray {

//	public int getLongestSubArray(int []a) {
//		int [][]maxSub = new int[a.length][a.length];
//		for(int i = 0; i < a.length; ++i) {
//			for(int j = 0; j < a.length; ++j) {
//				if(i == j)
//					maxSub[i][i] = a[i];
//				else
//					maxSub[i][j] = Integer.MIN_VALUE;
//			}
//		}
//		
//		for(int l = 1; l < a.length; ++l) {
//			for(int i = 0; i < a.length - l; ++i) {
//				int j = i + l;
//				for(int k = i; k < j; ++k) {
//					int q1 = maxSub[i][k];
//					int q2 = maxSub[k+1][j];
//					int q3 = q1 + q2;
//					int q = (q1 > q2 ? q1 : q2) > q3 ? (q1 > q2 ? q1 : q2) : q3;
//					maxSub[i][j] = maxSub[i][j] > q ? maxSub[i][j] : q;
//				}
//			}
//		}
//		
//		return maxSub[0][a.length-1];
//	}
	public int getLongestSubArray(int []a) {
		int []dp = new int[a.length];
		//int []
		dp[0] = a[0];
		for(int i = 1; i < a.length; ++i) {
			dp[i] = Integer.MIN_VALUE;
		}
		for(int i = 1; i < a.length; ++i) {
			if(dp[i] < dp[i - 1] + a[i]) {
				if(dp[i - 1] > 0)
					dp[i] = dp[i - 1] + a[i];
				else
					dp[i] = a[i];
				}
		}
		return dp[a.length - 1];
	}
	
	@Test
	public void test() {
		int[] a = {2,3,5,-4,-2,-6,12,5,2};
		System.out.println(getLongestSubArray(a));
	}
}
