package com.test;

import org.junit.jupiter.api.Test;

public class BST<Key extends Comparable<Key>, Value> {
	public Node root;
	
	class Node{
		Key key;   //键
		Value val; //值
		Node left; //左子节点
		Node right; //右子节点
		
		int N;    //以该节点为根的子树的大小
	}
	
	//put函数
	public void put(Key key, Value val) {
		root = put(root, key, val);
	}
	
	//以x为根节点的树中插入键值对
	private Node put(Node x, Key key, Value val) {
		//如果是空表
		if(null == x) {
			x = new Node();
			x.key = key;
			x.val = val;
			x.N = 1;
			return x;
		}
		//非空表
		if(x.key.equals(key)) {
			x.val = val;
		}
		else if(x.key.compareTo(key) < 0){
			x.right = put(x.right, key, val);
		}
		else {
			x.left = put(x.left, key, val);
		}
		//x.N = size(x.left) + size(x.right) + 1;
		x.N++;
		return x;
	}
	
	public Value get(Key key) {
		return get(root, key);
	}
	
	//以x为根节点的字数中查找键
	private Value get(Node x, Key key) {
		if(x == null) return null;
		if(x.key.equals(key))  return x.val;
		else if(key.compareTo(x.key) > 0) return get(x.right, key);
		else return get(x.left, key);
		
	}
	
	
	public int size() {
		return size(root);
	}
	
	public int size(Node x) {
		if(x == null) return 0;
		return x.N;
	}
	
	public Key min() {
		return min(root).key;
	}
	
	private Node min(Node x) {
		if(x.left == null) return x;
		else return min(x.left);
	}
	
	public Key floor(Key key) {
		Node x = floor(root, key);
		if(null == x) return null;
		return x.key;
	}
	
	private Node floor(Node x, Key key) {
		if(x == null) return x;
		if(x.key.equals(key)) return x;
		if(x.key.compareTo(key) > 0)
			return floor(x.left, key);
		Node temp = floor(x.right, key);
		if(temp != null) 
			return temp;   //如果右子树有比key小的key
		else return x;
	}
	
	public Key select(int k) {
		return select(root, k).key;
	}
	private Node select(Node x, int k) {
		if(null == x) return null;
		if(size(x.left) > k) {
			return select(x.left, k);
		}
		else if(size(x.left) == k) {
			return x;
		}
		else {
			return select(x.right, k - size(x.left) - 1);
		}
	}
	
	public int rank(Key key) {
		return rank(root, key);
	}

	private int rank(Node x, Key key) {
		if(x == null) return 0;
		if(x.key.compareTo(key) > 0) {
			return rank(x.left, key);
		}
		else if(x.key.compareTo(key) == 0) {
			return size(x.left);
		}
		else {
			return size(x.left) + rank(x.right, key) + 1;
		}
	}
	
	public void deleteMin() {
		root = deleteMin(root);
	}
	
	public Node deleteMin(Node x) {
		if(x == null) return null;
		if(x.left == null) {
			return x.right;
		}
		else {
			x.left = deleteMin(x.left);
			x.N = size(x.left) + size(x.right) + 1;
			return x;
		}
	}
	
	private void print(Node x) {
		if(x == null) return;
		print(x.left);
		System.out.println(x.key);
		print(x.right);
	}
	
	public void print() {
		print(root);
	}
}	
	
