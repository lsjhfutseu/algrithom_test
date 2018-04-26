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
	 * 生产商品
	 * */
	public void produce(String producer){
		synchronized (list) {
			while(list.size() >= Max_Size){
				System.out.println(producer+"生产已达到上限！");
				try {
					list.wait();  //生产达上限，则产生生产阻塞
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			list.add(new Object());
			System.out.println(producer+"生产成功！");
			list.notifyAll();
		}
	}
	
	/*  
	 * 消费商品
	 * */
	public void consume(String consumer){
		synchronized (list) {
			while(list == null || list.size() == 0){
				System.out.println(consumer+"产品已卖完！");
				try {
					list.wait();   //商品卖完，消费产生阻塞
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			list.remove();
			System.out.println(consumer+"消费成功！");
			list.notifyAll();
		}
	}
}
