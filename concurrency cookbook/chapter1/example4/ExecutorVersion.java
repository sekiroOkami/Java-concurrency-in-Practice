package chapter1.example4;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.*;
import java.util.Date;

/**
 * Write a description of class ExecutorVersion here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ExecutorVersion
{
    public static void main() {
        var clock = new ExecutorVersion(). new ConsoleClock();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        try {
            Future<ConsoleClock> future = executor.submit(clock);
            TimeUnit.SECONDS.sleep(5);
            //interrupt the task
            future.cancel(true);
            // Attempt to get the result of the task
            ConsoleClock result = future.get(); // This will throw CancellationException
        } catch (CancellationException e) {
            System.out.printf("The task was cancelled\n");
        } catch (InterruptedException e) {
            System.out.printf("The MainThread was Interrupted\n");
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
    
    class ConsoleClock implements Callable<ConsoleClock> {
        @Override
        public ConsoleClock call() {
            for (int i=0; i< 10; i++) {
                System.out.printf("%s\n", new Date());
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    System.out.printf("The FileClock has been interrupted\n");
                }
            }
            return this;
        }
    }
}
