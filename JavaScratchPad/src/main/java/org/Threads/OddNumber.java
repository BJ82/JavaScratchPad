package org.Threads;

public class OddNumber extends Thread{
    public void run()
    {
        for(int i=1;i<=49;i+=2){
            System.out.println(i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
