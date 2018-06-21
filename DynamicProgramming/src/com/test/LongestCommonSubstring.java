package com.test;

import org.junit.jupiter.api.Test;

public class LongestCommonSubstring {
	public int getLCS(int [][]c, String a, String b, int i, int j) {
		if(c[i][j] != -1) {
			return c[i][j];
		}
		if(i == 0 || j == 0){
			c[i][j] = 0;
		}
		else if(a.charAt(i - 1) == b.charAt(j - 1)) {
			c[i][j] = getLCS(c, a, b, i - 1, j-1) + 1;
		}
		else {
			c[i][j - 1] = getLCS(c, a, b, i, j-1);
			c[i-1][j] = getLCS(c, a, b, i-1, j);
			c[i][j] = c[i][j - 1] > c[i-1][j] ? c[i][j - 1] : c[i-1][j];
		}
		return c[i][j];
	}
	
	@Test
	public void test() {
		String a = "ACCGGTCGAGTGCGCGGAAGCCGGCCGAA";
		String b = "GTCGTTCGGAATGCCGTTGCTCTGTAAA";
		int [][]c = new int[a.length() + 1][b.length() + 1];
		for(int i = 0; i < a.length() + 1; ++i) {
			for(int j = 0; j < b.length() + 1; ++j) {
				c[i][j] = -1;
			}
		}
		int result = getLCS(c, a, b, a.length(), b.length());
		System.out.println();
		System.out.println(result);
	}
}
