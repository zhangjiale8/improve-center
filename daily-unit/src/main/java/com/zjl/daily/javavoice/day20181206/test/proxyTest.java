package com.zjl.daily.javavoice.day20181206.test;

import java.lang.reflect.Proxy;

import com.zjl.daily.javavoice.day20181206.CustomInvocationHandler;
import com.zjl.daily.javavoice.day20181206.HelloWorld;
import com.zjl.daily.javavoice.day20181206.impl.HelloWorldImpl;

public class proxyTest {
	public static void main(String[] args) {
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
		CustomInvocationHandler handler = new CustomInvocationHandler(new HelloWorldImpl());
		HelloWorld proxy = (HelloWorld) Proxy.newProxyInstance(proxyTest.class.getClassLoader(),
				new Class[] {HelloWorld.class}, handler);
		proxy.sayHello("Mikan");
	}
}
