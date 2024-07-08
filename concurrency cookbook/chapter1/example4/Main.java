package chapter1.example4;
import java.util.concurrent.*;
import java.util.Date;

/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
    public static void main(String[] args) {
        var clock = new Main(). new ConsoleClock();
        Thread thread = new Thread(clock);
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            System.out.printf("Main thread has been interrupted");
        }
        thread.interrupt();
    }

    class ConsoleClock implements Runnable {

        @Override
        public void run() {
            for (int i=0; i< 10; i++) {
                System.out.printf("%s\n", new Date());
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    System.out.printf("The FileClock has been interrupted\n");
                }
            }
        }
    }
}
