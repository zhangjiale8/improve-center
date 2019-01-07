package com.zjl.spring.chapter02.xml;


import com.zjl.spring.chapter02.CompactDisc;

public class SgtPeppers implements CompactDisc{
	private String title ="Sgt. pepper’s Lonely hearts Club Band";
	private String artist = "The Beatles";
	public void paly() {
		System.out.println("playing " + title +" By "+artist);
		
	}

}
