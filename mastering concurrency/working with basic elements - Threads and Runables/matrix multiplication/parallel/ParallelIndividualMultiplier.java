package parallel;

import java.util.*;
/**
 * Write a description of class ParallelIndividualMultiplier here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ParallelIndividualMultiplier
{
    public static void multiply(double[][] matrix1, double[][] matrix2, double[][] result) {
        List<Thread> threads = new ArrayList<>();
        int rows1 = matrix1.length;
        int columns = matrix2.length;
        
        for(int i = 0; i < rows1; i++) {
            
            for(int j = 0; j < columns; j++) {
                IndividualMultiplierTask task = new IndividualMultiplierTask(result, matrix1, matrix2, i, j);
                
                Thread thread = new Thread(task);
                thread.start();
                threads.add(thread);
                if (threads.size()  % 10 ==0) {
                    waitForThreads(threads);
                }
            }
        }
    }
    
    private static void waitForThreads(List<Thread> threads) {
        for (Thread thread: threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        threads.clear();
    }
}
