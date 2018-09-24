package com.zjl.designmodel.factory.factorymethod;

import com.zjl.designmodel.factory.factorymethod.service.Sender;
import com.zjl.designmodel.factory.factorymethod.service.impl.MailSender;

public class SendMailFactory implements Provider {

	public Sender produce() {
		
		return  new MailSender();
	}

}
