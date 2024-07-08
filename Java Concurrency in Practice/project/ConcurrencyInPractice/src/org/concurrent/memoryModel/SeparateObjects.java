package org.concurrent.memoryModel;

public class SeparateObjects {
    public static void main(String[] args) {

        var myObject = new MyObject();

        var runnable1 = new MyRunnable(myObject);
        var runnable2 = new MyRunnable(myObject);

        Thread thread1 = new Thread(runnable1, "Thread 1");
        Thread thread2 = new Thread(runnable2, "Thread 2");

        thread1.start();
        thread2.start();

    }
}
