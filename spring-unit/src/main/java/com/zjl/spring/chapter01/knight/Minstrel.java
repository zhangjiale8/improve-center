package com.zjl.spring.chapter01.knight;
/**
 * 
 * @Description:游吟诗人 
 * @author: zhangjiale
 * @date:   2019年1月7日 上午10:30:26   
 *     
 * @Copyright: 2019
 */

import java.io.PrintStream;

public class Minstrel {
	private PrintStream printStream;

	public Minstrel(PrintStream printStream) {
		this.printStream = printStream;
	}
	
	public void singBeforeQuest() {
		printStream.println("fa,fa,fa , the knight is so brave");
	}
	
	public void singAfterQuest() {
		printStream.println("tee,tee,tee , the brave knight did embark on a quest !");
	}
	
}
