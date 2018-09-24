package com.zjl.designmodel.factory.factorymethod;

import com.zjl.designmodel.factory.factorymethod.service.Sender;

public interface Provider {
	public Sender produce();
}
