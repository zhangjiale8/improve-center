package com.zjl.daily.javavoice.day20181217.designModel.Flyweight;

import java.util.HashMap;
import java.util.Map;

public class Factory {//图件工厂
	     private Map<String, Drawable> images;//图库
	 
	     public Factory() {
	         images = new HashMap<String, Drawable>();
	     }
	 
	     public Drawable getDrawable(String image) {
	         //缓存里如果没有图件，则实例化并放入缓存。
	        if(!images.containsKey(image)){
	            switch (image) {
	            case "河流":
	                images.put(image, new Water());
	                break;
	            case "草坪":
	                images.put(image, new Grass());
	                break;
	            case "石路":
	                images.put(image, new Stone());
	            }
	        }
	        //缓存里必然有图，直接取得并返回。
	        return images.get(image);
	    }
}
