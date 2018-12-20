package com.zjl.daily.javavoice.day20181217.designModel.memento;

public class Doc {
	 private String title;//文章名字
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

    public History createHistory() {
        return new History(body);//创建历史记录
    }

    public void restoreHistory(History history){
        this.body = history.getBody();//恢复历史记录
    }
}
