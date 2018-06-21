package com.test;

import org.junit.jupiter.api.Test;

public class MergeSort {
	//利用归并排序
    public int InversePairs(int [] array) {
        if(array.length < 2)
            return 0;
        int[] temp = new int[array.length];
        return sort(array, 0, array.length - 1,temp);
    }
    
    private int sort(int[]array, int low, int high, int[] temp){
        if(low >= high)
            return 0;
       int mid = (low + high) >> 1;
       int left_count = sort(array, low, mid, temp)%1000000007;
       int right_count = sort(array, mid + 1, high, temp)%1000000007;
       int count = merge(array, low, mid, high, temp);
       return (left_count + right_count + count)%1000000007;
    }
    
    private int merge(int []array, int low, int mid, int high, int[] temp){
        int i = low, j = mid + 1;
        int k = low;
        int count = 0;
        while(i <= mid && j <= high){
            if(array[i] < array[j]){
                temp[k++] = array[i++];
            }
            else{
                temp[k++] = array[j++];
                count += (mid + 1 - i);
                if(count>=1000000007)//数值过大求余
                	count%=1000000007;
            }
        }
        while(i <= mid){
            temp[k++] = array[i++];
        }
        while(j <= high){
            temp[k++] = array[j++];
        }
        for(k = low; k<= high; k++){
            array[k] = temp[k];
        }
        return count;
    }
    
    @Test
    public void test1() {
    	int []a = {4,1,2,3,5,6,7,0};
    	int i = InversePairs(a);
    	System.out.println(i);
    }
}
