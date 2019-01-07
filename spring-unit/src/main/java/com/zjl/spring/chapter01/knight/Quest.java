package com.zjl.spring.chapter01.knight;

/**
 * 
 * @Description:指示命令
 * @author: zhangjiale
 * @date:   2019年1月7日 上午10:30:51   
 *     
 * @Copyright: 2019
 */
public interface Quest {
  public Object embark() throws QuestFailedException;
}
