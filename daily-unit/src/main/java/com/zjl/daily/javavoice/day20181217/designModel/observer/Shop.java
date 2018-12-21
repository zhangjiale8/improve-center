package com.zjl.daily.javavoice.day20181217.designModel.observer;

import java.util.ArrayList;
import java.util.List;

public class Shop {
	 
     private String product;
     private List<Buyer> buyers;// 持有买家的引用
 
     public Shop() {
         this.product = "无商品";
         this.buyers = new ArrayList<>();
     }

    // 为了主动通知买家，买家得来店里注册。
    public void register(Buyer buyer) {
        this.buyers.add(buyer);
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;// 到货了
        notifyBuyers();// 到货后通知买家
    }

    // 通知所有注册买家
    public void notifyBuyers() {
        buyers.stream().forEach(b -> b.inform());
    }
}