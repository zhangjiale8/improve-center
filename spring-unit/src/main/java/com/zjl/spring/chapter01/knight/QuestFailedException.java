package com.zjl.spring.chapter01.knight;

@SuppressWarnings("serial")
public class QuestFailedException extends Exception {
  public QuestFailedException() {}
  
  public QuestFailedException(String message) {
    super(message);
  }
}
