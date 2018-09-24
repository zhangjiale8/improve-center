package com.zjl.designmodel.factory.simple.multistatic;

import com.zjl.designmodel.factory.simple.multistatic.service.Sender;

public class FactoryTest {
	public static void main(String[] args) {
		Sender sender = SendFactory.produceSms();
		sender.Send();
	}
}
