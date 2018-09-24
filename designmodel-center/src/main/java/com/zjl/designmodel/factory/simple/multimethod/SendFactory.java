package com.zjl.designmodel.factory.simple.multimethod;

import com.zjl.designmodel.factory.simple.multimethod.service.Sender;
import com.zjl.designmodel.factory.simple.multimethod.service.impl.MailSender;
import com.zjl.designmodel.factory.simple.multimethod.service.impl.SmsSender;

public class SendFactory {

	public Sender produceMail() {
		return new MailSender();
	}

	public Sender produceSms() {
		
		return new SmsSender();
	}
	
}
