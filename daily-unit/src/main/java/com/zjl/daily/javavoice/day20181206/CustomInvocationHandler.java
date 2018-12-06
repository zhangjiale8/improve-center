package com.zjl.daily.javavoice.day20181206;

import java.lang.reflect.Method;

import java.lang.reflect.InvocationHandler;

public class CustomInvocationHandler implements InvocationHandler{
	private Object target;
	
	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

	public CustomInvocationHandler(Object target) {
		this.target = target;
	}
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("Before invocation");
		Object retVal = method.invoke(proxy, args);
		System.out.println("After invocation");
		return retVal;
	}
	
	

}
