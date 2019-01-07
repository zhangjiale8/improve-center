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
	public BraveKnight(Quest quest) {
		this.quest = quest;
	}

	public Object embarkOnQuest() throws QuestFailedException {
		
		return quest.embark();
	}

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
