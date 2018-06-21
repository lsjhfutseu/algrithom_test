package com.test;

import java.util.Date;

import org.junit.jupiter.api.Test;

public class SortTest extends Date{

	/*
	 * 快速排序
	 * */
	public void quickSort(Comparable []a, int low, int high) {
		if(low >= high) return;
		int j = cut(a, low, high);
		quickSort(a, low, j - 1);
		quickSort(a, j + 1, high);
	}
	
	/*
	 * 快速排序切分方法
	 * */
	public int cut(Comparable []a, int low, int high) {
		Comparable v = a[low];
		int i = low, j = high + 1;
		while(true) {
			while(less(a[++i], v)) if(i >= high) break;
			while(less(v, a[--j])) if(j <= low) break;
			if(i >= j) break;
			exchange(a, i, j);
		}
		exchange(a, low, j);
		return j;
	}
	
	/*
	 * 堆排序
	 * */
	public void heapSort(Comparable []a) {
		//下沉法构造堆
//		for(int k = a.length / 2; k >= 1; k--) {
//			sink(a, k, a.length-1);
//		}
		
		//上浮法构造堆
		for(int k = 1; k < a.length; ++k) {
			swim(a, k , a.length - 1);
		}
		
		//利用下沉排序
		for(int k = a.length - 1; k > 0; k--) {
			exchange(a, 1, k);
			sink(a, 1, k - 1);
		}  
	}
	
	//完全二叉树的上浮
	public void swim(Comparable []a, int k, int N) {
		while(k > 1) {
			int j = k / 2;
			if(!less(a[j], a[k])) break;
			exchange(a, j, k);
			k = j;
		}
	}
	
	//完全二叉树的下沉
	public void sink(Comparable []a, int k, int N) {
		while(k <= N/2) {
			int j = 2 * k;
			if(j < N && less(a[j], a[j + 1])) j++;
			if(less(a[j], a[k])) break;
			exchange(a, k, j);
			k = j;
		}
	}
	
	public boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}
	
	public void exchange(Comparable []a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	@Test
	public void test() {
		Comparable[] a = {121,44,8,925,45,10,536,56,5656,63,626,6};
		//quickSort(a,0,a.length-1);
		heapSort(a);
		for(int i = 0; i < a.length; ++i)
			System.out.println(a[i]);
	}
	
	@Test
	public void hh() {
		System.out.println(test1());
	}
	
	public int test1() {
		int x = 2;
		try {
			return x;
		} finally {
			// TODO: handle finally clause
			++x;
			return x;
		}
	}
	
	
}
