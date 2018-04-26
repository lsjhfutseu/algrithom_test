package com.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class ReadInputTest {
	
	@Test
	public void readLineTest() throws IOException {
		FileInputStream fis = new FileInputStream("f://单元柜2.txt");  //字节流
		InputStreamReader isr = new InputStreamReader(fis, "utf-8");  //转换为字符流
		BufferedReader br = new BufferedReader(isr);    //存到缓存区
		Map<String, Integer> map = new HashMap<String, Integer>();
		String str;
		while((str = br.readLine()) != null) {
			String[] wordList = str.split("\\s+");
			for(int i = 0; i < wordList.length; ++i) {
				if(!wordList[i].matches("\\w+"))
					continue;
				if(map.containsKey(wordList[i])) {
					map.put(wordList[i], map.get(wordList[i])+1);
				}
				else {
					map.put(wordList[i], 1);
				}
			}
		}
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey()+": "+entry.getValue());
		}
	}
	
	@Test
	public void readWordTest() throws IOException {
		FileReader fr = new FileReader("f://单元柜2.txt");   //直接是字符流
		char[] buffer = new char[1024];
		int len = fr.read(buffer);
//		for(int i = 0; i < buffer.length; ++i)
//			System.out.println(buffer[i]);
		String str = new String(buffer,0,len);
		System.out.println(str);
	}
	
	@Test
	public void saveTest() throws IOException{
//		FileWriter fw = new FileWriter("e://test.txt");
//		fw.write("hello word");
//		fw.close();	
		FileOutputStream fos = new FileOutputStream("e://test2.txt");
		fos.write("hello word".getBytes("UTF-8"));
		fos.close();
	}
	
	@Test
	public void test() {
		int i = 0;
		System.out.println(i);
	}
}
