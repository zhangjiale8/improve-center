package com.zjl.spring.chapter01.knight;

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
