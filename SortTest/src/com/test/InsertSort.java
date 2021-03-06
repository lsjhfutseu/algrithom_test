package com.test;

import org.junit.jupiter.api.Test;

public class InsertSort {
	private int []a = {1,5,6,8,9,7,4,5,3,9,74,52,558,65,25,1520,56, 44};
	
	
	/*
	 * ѡ������
	 * */
	@Test
	public void chooseSort() {
		for(int i = 0; i < a.length; ++i) {
			int min = i;
			for(int j = i + 1; j < a.length; ++j) {
				if(a[j] < a[min]) min = j;
			}
			exchange(i, min);
		}
		for(int i = 0; i < a.length; ++i)
			System.out.println(a[i]);
	}
	
	/*
	 * ��������
	 * */
	@Test
	public void insertSort() {
		for(int i = 0; i < a.length; ++i){
			for(int j = i; j > 0 && a[j] < a[j - 1]; --j) {
				exchange(j, j-1);
			}
		}
		
		for(int i = 0; i < a.length; ++i)
			System.out.println(a[i]);
	}
	
	/*
	 * ϣ������
	 * */
	@Test
	public void shellSort() {
		int h = a.length / 2;
		while(h >= 1) {
			for(int i = h; i < a.length; i++) {
				for(int j = i; j > h && a[j] < a[j-h]; j-=h) {
					exchange(j,j-h);
				}
			}
			h /= 2;
		}
		for(int i = 0; i < a.length; ++i)
			System.out.println(a[i]);
	}
	
	public void exchange(int i, int j) {
		if(i == j) return;
		
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	/*
	 * �鲢����
	 * */
	@Test
	public void mergeSortTest() {
		mergeSort(0,a.length - 1);
		for(int i = 0; i < a.length; ++i)
			System.out.println(a[i]);
	}
	
	
	
	/*
	 * �Զ�����
	 * */
	public void mergeSort(int low, int high) {
		if(low >=high)
			return;
		int mid = (low + high) / 2;
		mergeSort(low, mid);
		mergeSort(mid+1, high);
		merge(low, mid,high);
	}
	
	public void merge(int low, int mid, int high) {
		int []b = new int[a.length];
		try {
			for(int i = low; i <= high; ++i) {
				b[i] = a[i];
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		int i = low, j = mid+1;
		for(int k = low; k <= high; ++k) {
			try {
				if(i > mid) a[k] = b[j++];
				else if(j > high) a[k] = b[i++];
				else if(b[i] < b[j]){
					a[k] = b[i];
					i++;
				}
				else {
					a[k] = b[j];
					j++;
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
	}
	
	/*
	 * �Ե�����
	 * */
	@Test
	public void mergeSort2() {
		int size = 1;
		for(;size < a.length ; size*=2) {
			for(int i = 0; i < a.length - size; i+= (size*2)) {
				merge(i, i+size -1, Math.min(i+size*2-1, a.length -1));
			}
		}
		for(int i = 0; i < a.length; ++i)
			System.out.println(a[i]);
	}
	
}
