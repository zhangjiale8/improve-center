package com.zjl.designmodel.factory.simple.multistatic;

import com.zjl.designmodel.factory.simple.multistatic.service.Sender;
import com.zjl.designmodel.factory.simple.multistatic.service.impl.MailSender;
import com.zjl.designmodel.factory.simple.multistatic.service.impl.SmsSender;

public class SendFactory {

	public static Sender produceMail() {
		
		return new MailSender();
	}

	public static Sender produceSms() {
		
		return new SmsSender();
	}

	
	
}
