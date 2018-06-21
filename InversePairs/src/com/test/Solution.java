package com.test;

import org.junit.jupiter.api.Test;

public class Solution {
	public int InversePairs(int [] array) {
        if(array.length < 2)
            return 0;
        return InversePairs(array, array.length - 1)%1000000007;
    }
    
    public int InversePairs(int [] array, int high){
        if(high == 2){
            if(array[1] < array[0])
                return 1;
            else return 0;
        }
        return InversePairs(array, high - 1) + findInversePairsEnd(array, high);
    }
    
    private int findInversePairsEnd(int [] array, int high){
        int count = 0;
        for(int i = high - 1; i >= 0; --i){
            if(array[high] < array[i])
              count++;
        }
        return count;
    }
    
    @Test
    public void test() {
    	int []a = {4,1,2,3,5,6,7,0};
    	int i = InversePairs(a);
    	System.out.println(i);
    }
}
