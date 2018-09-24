package com.zjl.designmodel.factory.simple.multimethod.service.impl;

import com.zjl.designmodel.factory.simple.multimethod.service.Sender;

public class SmsSender implements Sender {

	public void Send() {
		System.out.println("this is SmsSender !");

	}

}
