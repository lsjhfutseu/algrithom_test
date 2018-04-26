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
	
	//����Ԫ��
	public void put(Key key, Value val) {
		//����ǿձ�
		if(first == null) {
			first = new Node();
			first.key = key;
			first.val = val;
			first.next = null;
			size++;
		}
		//������ǿձ�
		else {
			//�ȱ�����û�иü�
			Node temp = first;
			while(temp != null) {
				if(temp.key.equals(key)) {
					temp.val = val;
					return;
				}
				temp = temp.next;
			}
			//û�иü�
			Node oldfirst = first;
			first = new Node();
			first.key = key;
			first.val = val;
			first.next = oldfirst;
			size++;
		}
	}
	
	//����key�õ�Ԫ��
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
	
	//ɾ��ĳ����ֵ��
	public void delete(Key key) {
		Node temp = new Node();
		temp.next = first;
		while(temp.next != null) {
			if(temp.next.key.equals(key)) {
				//����ҵ��ü���ɾ��
				temp.next = temp.next.next;
				size--;
				return;
			}
			temp = temp.next;
		}
	}
	
	//�Ƿ����ĳ����ֵ��
	public boolean contains(Key key) {
		Node temp = first;
		while(temp != null) {
			if(temp.key.equals(key)) {
				//����ҵ��ü�
				return true;
			}
			temp = temp.next;
		}
		return false;
	}
	
	//���Ƿ�Ϊ��
	public boolean isEmpty() {
		if(first == null)
			return true;
		else
			return false;
	}
	
	//��ļ�ֵ�Ը���
	public int size() {
		return size;
	}
	
	
	//������
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







