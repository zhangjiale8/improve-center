package com.zjl.designmodel.factory.simple.multimethod.service.impl;

import com.zjl.designmodel.factory.simple.multimethod.service.Sender;

public class MailSender implements Sender {

	public void Send() {
		System.out.println("this is MailSender !");
		
	}

	
}
