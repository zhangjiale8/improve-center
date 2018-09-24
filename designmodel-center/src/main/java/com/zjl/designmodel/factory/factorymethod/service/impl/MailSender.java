package com.zjl.designmodel.factory.factorymethod.service.impl;

import com.zjl.designmodel.factory.factorymethod.service.Sender;

public class MailSender implements Sender {

	public void Send() {
		System.out.println("this is MailSender !");
		
	}

	
}
