package chapter1.example5;

import java.util.Date;
import java.util.concurrent.*;

/**
 * Write a description of class ThreadMain here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ThreadMain
{
    
    public static void main(String[] args) {
        var dsLoader = new ThreadMain().new DataSourcesLoader();
        var thread1 = new Thread(dsLoader, "Ds Thread");
        var ncLoader = new ThreadMain().new NetworkConnectionsLoader();
        var thread2 = new Thread(ncLoader, "Nc Thread");
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        
        // Waits a message
	System.out.printf("Main: Configuration has been loaded: %s\n",new Date());
    }
    
    class DataSourcesLoader implements Runnable {
        @Override
        public void run() {
            System.out.printf("Beginnig data sources loading: %s\n",
                new Date());
                
            try {
                TimeUnit.SECONDS.sleep(4);
            }  catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            System.out.printf("Data sources loading has finished: %s\n",
                new Date());
        }
    }
    
    class NetworkConnectionsLoader implements Runnable {
        // public DataSourcesLoader datasourcesLoader;
        
        // public NetworkConnectionsLoader(DataSourcesLoader datasourcesLoader) {
            // this.datasourcesLoader = datasourcesLoader;
        // }
        @Override 
        public void run() {
            System.out.printf("Beginning Network loading: %s\n",
                new Date());
                
            try {
                TimeUnit.SECONDS.sleep(6);
            }  catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            System.out.printf("Network establish has finished: %s\n",
                new Date());
        }
    }
}
