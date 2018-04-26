package com.test;

import java.util.LinkedList;
import java.util.List;

public class Storage {
	private long Max_Size;
	private LinkedList<Object> list = new LinkedList<Object>();
	
	public long getMax_Size() {
		return Max_Size;
	}

	public void setMax_Size(long max_Size) {
		Max_Size = max_Size;
	}

	/*  
	 * ������Ʒ
	 * */
	public void produce(String producer){
		synchronized (list) {
			while(list.size() >= Max_Size){
				System.out.println(producer+"�����Ѵﵽ���ޣ�");
				try {
					list.wait();  //���������ޣ��������������
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			list.add(new Object());
			System.out.println(producer+"�����ɹ���");
			list.notifyAll();
		}
	}
	
	/*  
	 * ������Ʒ
	 * */
	public void consume(String consumer){
		synchronized (list) {
			while(list == null || list.size() == 0){
				System.out.println(consumer+"��Ʒ�����꣡");
				try {
					list.wait();   //��Ʒ���꣬���Ѳ�������
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			list.remove();
			System.out.println(consumer+"���ѳɹ���");
			list.notifyAll();
		}
	}
}
