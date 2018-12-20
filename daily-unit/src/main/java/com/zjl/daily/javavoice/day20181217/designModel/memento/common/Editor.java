package com.zjl.daily.javavoice.day20181217.designModel.memento.common;

public class Editor {//编辑器
     private Doc doc;//文档引用
 
     public Editor(Doc doc) {
         System.out.println("<<<打开文档" + doc.getTitle());
         this.doc = doc;
         show();
     }
 
    public void append(String txt) {
        System.out.println("<<<插入操作");
        doc.setBody(doc.getBody() + txt);
        show();
    }

    public void save(){
        System.out.println("<<<存盘操作");
    }

    public void delete(){
        System.out.println("<<<删除操作");
        doc.setBody("");
        show();
    }

    private void show(){//显示当前文本内容
        System.out.println(doc.getBody());
        System.out.println("文章结束>>>n");
    }
}
