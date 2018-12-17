package com.zjl.daily.javavoice.day20181217.designModel.prototype;
/**
 * 深浅拷贝
 * @author zhangjiale
 *
 */
public class MemberwiseAndBitwise implements Cloneable{
	 private Bullet bullet = new Bullet();
	 
	 public void setBullet(Bullet bullet) {
	        this.bullet = bullet;
	}
	 
    @Override
    protected MemberwiseAndBitwise clone() throws CloneNotSupportedException {
    	MemberwiseAndBitwise clonePlane = (MemberwiseAndBitwise) super.clone();//先克隆出敌机，其中子弹还未进行克隆。
        //clonePlane.setBullet(this.bullet.clone());//对子弹进行深拷贝
        return clonePlane;
    }
}
