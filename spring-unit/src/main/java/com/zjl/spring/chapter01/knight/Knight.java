package com.zjl.spring.chapter01.knight;


public interface Knight {
  public Object embarkOnQuest() throws QuestFailedException;
  public String getName();
}
