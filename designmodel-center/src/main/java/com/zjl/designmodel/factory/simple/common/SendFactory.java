package com.zjl.designmodel.factory.simple.common;

import com.zjl.designmodel.factory.simple.common.service.Sender;
import com.zjl.designmodel.factory.simple.common.service.impl.MailSender;
import com.zjl.designmodel.factory.simple.common.service.impl.SmsSender;

public class SendFactory {

	public Sender produce(String type) {
		if("sms".equals(type)){
			return new SmsSender();
		}else if("mail".equals(type)){
			return new MailSender();
		}else{
			System.out.println("请输入正确的类型！");
			return null;
		}
	}
	
}
