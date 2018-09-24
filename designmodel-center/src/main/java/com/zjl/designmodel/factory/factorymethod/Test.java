package com.zjl.designmodel.factory.factorymethod;

import com.zjl.designmodel.factory.factorymethod.service.Sender;

public class Test {
	public static void main(String[] args) {
		Provider provider = new SendMailFactory();
		Sender sender = provider.produce();
		sender.Send();
	}
}
