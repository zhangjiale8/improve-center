package com.zjl.spring.chapter01.knight;

@SuppressWarnings("serial")
public class GrailNotFoundException extends QuestFailedException {
  public GrailNotFoundException() {}
  
  public GrailNotFoundException(String message) {
    super(message);
  }
}
