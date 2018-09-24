package com.zjl.designmodel.factory.factorymethod;

import com.zjl.designmodel.factory.factorymethod.service.Sender;
import com.zjl.designmodel.factory.factorymethod.service.impl.SmsSender;

public class SendSmsFactory implements Provider {

	public Sender produce() {
		
		return new SmsSender();
	}

}
