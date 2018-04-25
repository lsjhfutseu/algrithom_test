package com.test;

import org.junit.jupiter.api.Test;

public class Stack {
    Node first;
	private class Node<Item>{
		Item item;
		Node next;
	}
	@Test
	public void TestHeadAdd() {
		first = new Node<Integer>();
		first.item = 1;
		first.next = null;
		Node oldfirst = first;
		first = new Node<Integer>();
		first.item = 2;
		first.next = oldfirst;
		
		for(Node node = first; node != null; node=node.next) {
			System.out.println(node.item);
		}
	}
	
	@Test
	public void TestHeadPop() {
		first = new Node<Integer>();
		first.item = 1;
		first.next = null;
		Node oldfirst = first;
		first = new Node<Integer>();
		first.item = 2;
		first.next = oldfirst;
		
		first = first.next;
		for(Node node = first; node != null; node=node.next) {
			System.out.println(node.item);
		}
	}
}
