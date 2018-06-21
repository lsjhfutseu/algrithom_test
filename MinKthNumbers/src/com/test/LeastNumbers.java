package com.test;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
public class LeastNumbers {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(k > input.length)
            return null;
        quickSort(input);
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < input.length; ++i){
            list.add(input[i]);
        }
        return list;
    }
    
    public void quickSort(int [] input){
        quickSort(input, 0, input.length - 1);
    }
    
    public void quickSort(int [] input, int start, int end){
        if(start >= end)
            return;
        int i = dividePosition(input, start, end);
        quickSort(input, start, i - 1);
        quickSort(input, i + 1, end);
    }
    
    public int dividePosition(int [] input, int start, int end){
        int number = input[end];
        int j = start;
        for(int i = start; i < end; ++i){
            if(input[i] < number){
                swap(input, i,j);
                ++j;
            }
        }
        swap(input, j, end);
        return j;
    }
    
    public void swap(int []input, int i, int j){
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
    
    @Test
    public void test1() {
    	int [] a = {4,5,1,6,2,7,3,8};
    	GetLeastNumbers_Solution(a, 10);
    	
    }
}
