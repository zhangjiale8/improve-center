package com.zjl.designmodel.factory.simple.common;

import com.zjl.designmodel.factory.simple.common.service.Sender;

public class FactoryTest {
	public static void main(String[] args) {
		SendFactory sendFactory = new SendFactory();
		Sender sender = sendFactory.produce("sms");
		sender.Send();
	}
}
