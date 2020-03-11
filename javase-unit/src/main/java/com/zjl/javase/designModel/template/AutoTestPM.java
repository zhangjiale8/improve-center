package com.zjl.javase.designModel.template;

public class AutoTestPM extends PM{

    @Override
    protected void analyze() {
        System.out.println("进行业务沟通，需求分析");     
    }

	@Override
	protected void design() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void develop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean test() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void release() {
		// TODO Auto-generated method stub
		
	}

	

    //design();develop();test();release();实现省略
}
