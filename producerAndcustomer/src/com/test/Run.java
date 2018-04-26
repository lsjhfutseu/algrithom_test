package com.test;

import com.producer.Customer;
import com.producer.Producer;

public class Run {
	public static void main(String []arc){
		Storage storage = new Storage();
		storage.setMax_Size(1);
		
		//生成与生产分别创建5个线程
		Customer customer1 = new Customer("消费者1",storage);
		Customer customer2 = new Customer("消费者2",storage);
		Customer customer3 = new Customer("消费者3",storage);
		Customer customer4 = new Customer("消费者4",storage);
		Customer customer5 = new Customer("消费者5",storage);
		
		Thread cusThread1 = new Thread(customer1);
		Thread cusThread2 = new Thread(customer2);
		Thread cusThread3 = new Thread(customer3);
		Thread cusThread4 = new Thread(customer4);
		Thread cusThread5 = new Thread(customer5);
		
		
		Producer producer1 = new Producer("生产者1",storage);
		Producer producer2 = new Producer("生产者2",storage);
		Producer producer3 = new Producer("生产者3",storage);
		Producer producer4 = new Producer("生产者4",storage);
		Producer producer5 = new Producer("生产者5",storage);
		
		Thread proThread1 = new Thread(producer1);
		Thread proThread2 = new Thread(producer2);
		Thread proThread3 = new Thread(producer3);
		Thread proThread4 = new Thread(producer4);
		Thread proThread5 = new Thread(producer5);
		cusThread1.start();
		proThread1.start();
		cusThread2.start();
		proThread2.start();
		cusThread3.start();
		proThread3.start();
		cusThread4.start();
		proThread4.start();
		cusThread5.start();
		proThread5.start();	
	}
}



