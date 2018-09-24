package com.zjl.designmodel.factory.simple.multimethod;

import com.zjl.designmodel.factory.simple.multimethod.SendFactory;
import com.zjl.designmodel.factory.simple.multimethod.service.Sender;

public class FactoryTest {
	public static void main(String[] args) {
		SendFactory sendFactory = new SendFactory();
		Sender sender = sendFactory.produceSms();
		sender.Send();
	}
}
