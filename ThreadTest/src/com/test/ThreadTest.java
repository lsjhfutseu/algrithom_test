package com.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.jupiter.api.Test;

public class ThreadTest {
	private int j = 1;
	
	private Lock lock = new ReentrantLock();
	
	private class Subtractor implements Runnable{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			//lock.lock();
			synchronized(ThreadTest.this) {
				System.out.println(j / 0);
			}
		}
		
	}
	
	@Test
	public void test() {
		Runnable thr = new Subtractor();
		Thread thread1 = new Thread(thr);
		Thread thread2 = new Thread(thr);
		thread1.start();
		thread2.start();
	}
}
