package com.zjl.spring.chapter01.knight;

/**
 * 
 * @Description:骑士 
 * @author: zhangjiale
 * @date:   2019年1月7日 上午10:32:07   
 *     
 * @Copyright: 2019
 */
public interface Knight {
  public Object embarkOnQuest() throws QuestFailedException;
  public String getName();
}
