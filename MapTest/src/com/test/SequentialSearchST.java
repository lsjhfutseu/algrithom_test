package com.test;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

public class SequentialSearchST<Key, Value> implements Iterable<Key>{

	private Node first;
	int size = 0;
	
	public class Node{
		Key key;
		Value val;
		Node next;
	}
	
	//插入元素
	public void put(Key key, Value val) {
		//如果是空表
		if(first == null) {
			first = new Node();
			first.key = key;
			first.val = val;
			first.next = null;
			size++;
		}
		//如果不是空表
		else {
			//先遍历有没有该键
			Node temp = first;
			while(temp != null) {
				if(temp.key.equals(key)) {
					temp.val = val;
					return;
				}
				temp = temp.next;
			}
			//没有该键
			Node oldfirst = first;
			first = new Node();
			first.key = key;
			first.val = val;
			first.next = oldfirst;
			size++;
		}
	}
	
	//根据key得到元素
	public Value get(Key key) {
		Node temp = first;
		while(temp != null) {
			if(temp.key.equals(key)) {
				return temp.val;
			}
			temp = temp.next;
		}
		return null;
	}
	
	//删除某个键值对
	public void delete(Key key) {
		Node temp = new Node();
		temp.next = first;
		while(temp.next != null) {
			if(temp.next.key.equals(key)) {
				//如果找到该键，删除
				temp.next = temp.next.next;
				size--;
				return;
			}
			temp = temp.next;
		}
	}
	
	//是否包含某个键值对
	public boolean contains(Key key) {
		Node temp = first;
		while(temp != null) {
			if(temp.key.equals(key)) {
				//如果找到该键
				return true;
			}
			temp = temp.next;
		}
		return false;
	}
	
	//表是否为空
	public boolean isEmpty() {
		if(first == null)
			return true;
		else
			return false;
	}
	
	//表的键值对个数
	public int size() {
		return size;
	}
	
	
	//迭代器
	public Iterator<Key> keys(){
		return new STIterator();
	}
	
	private class STIterator implements Iterator<Key>{
		private Node current = first;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			if(current != null)
				return true;
			else
				return false;
		}

		@Override
		public Key next() {
			Key key = current.key;
			current = current.next;
			return key;
		}
	}

	@Override
	public Iterator<Key> iterator() {
		return keys();
	}
}







