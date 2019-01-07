package com.zjl.spring.chapter02;

import org.springframework.stereotype.Component;
import javax.inject.Named;  
@Component("lonelyHeartsClub")
//@Named("lonelyHeartsClub")
public class SgtPeppers implements CompactDisc{
	private String title ="Sgt. pepper’s Lonely hearts Club Band";
	private String artist = "The Beatles";
	public void paly() {
		System.out.println("playing " + title +" By "+artist);
		
	}

}
