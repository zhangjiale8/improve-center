package com.zjl.spring.chapter01.knight;
/**
 * 
 * @Description:探险指示 
 * @author: zhangjiale
 * @date:   2019年1月7日 上午10:33:22   
 *     
 * @Copyright: 2019
 */
public class DamselRescuingKnight implements Knight{
	private RescueDamselQuest quest;
	
	public DamselRescuingKnight() {
		this.quest = new RescueDamselQuest();
	}

	public Object embarkOnQuest() throws QuestFailedException {
		
		return quest.embark();
	}

	public String getName() {
		
		return null;
	}

}
