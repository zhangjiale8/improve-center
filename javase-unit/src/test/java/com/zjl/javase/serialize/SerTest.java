package com.zjl.javase.serialize;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;


public class SerTest{
	
	@Test
	public void serializeToDisk()
    {
		
		try {
			Person ted = new Person("jiale", "zhang", 18);
			Person cha1 = new Person("le", "li", 28);
			ted.setSpouse(cha1);
			cha1.setSpouse(ted);
			FileOutputStream fos = new FileOutputStream("tempdata.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(ted);
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
    }
	
}
