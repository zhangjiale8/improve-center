package com.zjl.javase.designModel.memento.common;

public class Doc {
	 private String title;//文章标题
     private String body;//文章内容
 
     public Doc(String title){//新建文档先命名
         this.title = title;
         this.body = "";
     }
 
    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
