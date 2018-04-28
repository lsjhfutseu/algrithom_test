package com.test;

import org.junit.jupiter.api.Test;

public class CutRope {

	public int getMaxMulti(int n) {
		if(n < 2)
			return 0;
		if(n == 2)
			return 1;
		if(n == 3)
			return 2;
		int []maxMulti = new int[n + 1];
		maxMulti[0] = 0;
		maxMulti[1] = 1;
		maxMulti[2] = 2;
		maxMulti[3] = 3;
		for(int i = 4; i < n + 1; ++i) {
			maxMulti[i] = 0;
		}
		for(int i = 4; i < n + 1; ++i) {
			for(int j = 1; j < i / 2 + 1; ++j) {
				if(maxMulti[i] < maxMulti[j]*maxMulti[i - j]) {
					maxMulti[i] = maxMulti[j]*maxMulti[i - j];
				}
			}
		}
		return maxMulti[n];
	}
	
	@Test
	public void test() {
		System.out.println(getMaxMulti(8));
	}
}
