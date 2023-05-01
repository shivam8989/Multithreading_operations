package Multithreading;
import java.util.*;
public class Mult extends Thread {
    int x = 5;

    public void run() {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                x += i;
                System.out.println(x);
                this.notify();
            }

        }


    }

    public static void main(String[] args) {
        Mult m1 = new Mult();
        m1.start();
        synchronized (m1) {
            try {
                m1.wait();


                System.out.println("value of x " + m1.x);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

