package com.producer;

import com.test.Storage;

public class Producer implements Runnable{
	private Storage storage;
	private String producer;
	
	public Producer(String producer, Storage storage){
		super();
		this.producer = producer;
		this.storage = storage;
	}
	
	public void produce(){
		storage.produce(producer);
	}

	public Storage getStorage() {
		return storage;
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		produce();
	}
	
}
