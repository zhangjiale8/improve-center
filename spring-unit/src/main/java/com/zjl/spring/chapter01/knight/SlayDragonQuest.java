package com.zjl.spring.chapter01.knight;

import java.io.PrintStream;

public class SlayDragonQuest implements Quest{
	private PrintStream printStream;
	
	public SlayDragonQuest(PrintStream printStream) {
		this.printStream = printStream;
	}

	public Object embark() throws QuestFailedException {
		printStream.println("embarking on quest to slay the dragon");
		return null;
	}

}
