package com.test;

import org.junit.jupiter.api.Test;

public class Thread2 {
	
	private int j = 0;
	
	private class Add_runnable implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			synchronized(Thread2.this) {
				System.out.println(Thread.currentThread().getName()+"进入");
				++j;
				System.out.println(Thread.currentThread().getName() + j);
			}
			
		}
		
	}
	
	private class Sub_runnable implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			synchronized(Thread2.this) {
				System.out.println(Thread.currentThread().getName()+"进入");
				--j;
				System.out.println(Thread.currentThread().getName() + j);
			}
			
		}
		
	}
	
	@Test
	public void test() {
		Runnable add_runnable = new Add_runnable();
		Runnable sub_runnable = new Sub_runnable();
		new Thread(add_runnable).start();
		//new Thread(add_runnable).start();
		new Thread(sub_runnable).start();
		//new Thread(sub_runnable).start();
	}
}
