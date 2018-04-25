package com.test;

public class BST<Key extends Comparable<Key>, Value> {
	private Node root;
	
	private class Node{
		Key key;   //��
		Value val; //ֵ
		Node left; //���ӽڵ�
		Node right; //���ӽڵ�
		
		int N;    //�Ըýڵ�Ϊ���������Ĵ�С
	}
	
	//put����
	public void put(Key key, Value val) {
		put(root, key, val);
	}
	
	//��xΪ���ڵ�����в����ֵ��
	private Node put(Node x, Key key, Value val) {
		//����ǿձ�
		if(null == x) {
			x = new Node();
			x.key = key;
			x.val = val;
			x.left = null;
			x.right = null;
			x.N = 1;
			return x;
		}
		//�ǿձ�
		if(x.key.equals(key)) {
			x.val = val;
		}
		else if(x.key.compareTo(key) < 0){
			put(x.right, key, val);
		}
		else {
			put(x.left, key, val);
		}
		//x.N = size(x.left) + size(x.right) + 1;
		x.N++;
		return x;
	}
	
	public Value get(Key key) {
		return get(root, key);
	}
	
	//��xΪ���ڵ�������в��Ҽ�
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
			return temp;   //����������б�keyС��key
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
}