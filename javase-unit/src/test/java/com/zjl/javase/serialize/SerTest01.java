package com.zjl.javase.serialize;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;


public class SerTest01{
	
	@Test
	public void serializeToDisk()
    {
		
		try {
			FileInputStream fis = new FileInputStream("tempdata.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);			
			Person ted = (Person) ois.readObject();
			ois.close();
			System.out.println(ted.getFirstname());
			System.out.println(ted.getGender());
			System.out.println(ted.getAge());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
    }
	
}
