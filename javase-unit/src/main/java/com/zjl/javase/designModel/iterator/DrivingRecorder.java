package com.zjl.javase.designModel.iterator;

public class DrivingRecorder {
     private int index = -1;// 当前记录位置
     private String[] records = new String[10];// 假设只能记录10条视频
 
     public void append(String record) {
         if (index == 9) {// 循环覆盖
             index = 0;
         } else {
             index++;
        }
        records[index] = record;
    }

    public Iterator<String> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<String> {
        int cursor = index;// 迭代器游标，不染指原始游标。
        int loopCount = 0;

        @Override
        public boolean hasNext() {
            return loopCount < 10;
        }

        @Override
        public String next() {
            int i = cursor;// 记录即将返回的游标位置
            if (cursor == 0) {
                cursor = 9;
            } else {
                cursor--;
            }
            loopCount++;
            return records[i];
        }
    };
}
