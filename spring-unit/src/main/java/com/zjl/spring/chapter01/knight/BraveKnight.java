package com.zjl.spring.chapter01.knight;
/**
 * 
 * @Description:勇敢骑士  
 * @author: zhangjiale
 * @date:   2019年1月7日 上午10:32:27   
 *     
 * @Copyright: 2019
 */
public class BraveKnight implements Knight {
	
	private Quest quest;
	private Minstrel minstrel;
	public BraveKnight(Quest quest,Minstrel minstrel) {
		this.quest = quest;
		this.minstrel = minstrel;
	}
	
	public BraveKnight(Quest quest) {
		this.quest = quest;
	}

	public Object embarkOnQuest() throws QuestFailedException {
		quest.embark();
		return null;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
