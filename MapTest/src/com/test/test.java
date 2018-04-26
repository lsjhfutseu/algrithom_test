package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class test {
	
	@Test
	public void test() {
		SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
		st.put("test1", 1);
		st.put("test2", 2);
		st.put("test3", 3);
		st.put("test4", 4);
		st.put("test3", 5);

		Iterator it = st.keys();
//		while(it.hasNext())
//			System.out.println(it.next());
		//必须在前面指定泛型才能foreach来遍历
		for(String key: st){
			System.out.println(key);
		}
	}
	
	@Test
	public void testHashMap() {
		List<String> list = new ArrayList<String>();
		list.add("test1");
		list.add("test2");
		list.add("test3");
		list.add("test4");
		for(String key: list){
			System.out.println(key);
		}
	}
}
