package com.zjl.javase.thread;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {
	/**
     * @param args
     */
    public static void main(String[] args) {


        class TaskWithResult implements Callable<String>{

            private int id;
            public TaskWithResult(int id){
                this.id = id;
            }
            public String call() throws Exception {

                return "result of Callable "+id;
            }

        }

        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>>  results = new ArrayList<Future<String>>();
        for(int i=0;i<5;i++){
            results.add(exec.submit(new TaskWithResult(i)));
        }

        for(Future<String> fs:results){
            try {
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ExecutionException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }finally{
                exec.shutdown();
            }
        }
    }
}
