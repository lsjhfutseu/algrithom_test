package com.test;

import java.util.List;

import org.junit.jupiter.api.Test;

public class test {

	@Test
	public void test() {
		BST bst = new BST<>();
		bst.put(1, 1);
		bst.put(3, 3);
		bst.put(2, 2);
		bst.put(5, 5);
		bst.put(4, 4);
		bst.print();
	}
	
	@Test
	public void postorderTest() {
		Traversal<Integer, String> list = new Traversal<Integer, String>();
		list.put(8,"test");
		list.put(6,"test");
		list.put(10,"test");
		list.put(4,"test");
		list.put(7,"test");
		list.put(9,"test");
		list.put(12,"test");
		List result = list.postorderTraversal2();
		System.out.println(result);
	}
}
