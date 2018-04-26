package com.producer;

import com.test.Storage;

public class Customer implements Runnable{
	private String customer;
	private Storage storage;
	
	public Customer(String custome, Storage storage){
		super();
		this.customer = custome;
		this.storage = storage;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public Storage getStorage() {
		return storage;
	}
	public void setStorage(Storage storage) {
		this.storage = storage;
	}
	
	public void custume(){
		storage.consume(customer);
	}
	@Override
	public void run(){
		custume();
	}
}
