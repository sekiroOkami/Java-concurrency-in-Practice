package chapter1.example5;

import java.util.concurrent.*;
import java.util.Date;


/**
 * Write a description of class DataSourcesLoader here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ExecutorServiceMain
{
    public static void main(String[] args) {
        System.out.println("Start ExecutorServicePart");
        var dsLoader = new ExecutorServiceMain(). new DataSourcesLoader();
        var executor = Executors.newFixedThreadPool(2);
        var ncLoader = new ExecutorServiceMain(). new NetworkConnectionsLoader();
        var future1 = executor.submit(dsLoader);
        var future2 = executor.submit(ncLoader);
        try {
            future1.get();
            future2.get();
        } catch(InterruptedException e) {
            e.printStackTrace();
        } catch(ExecutionException  e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
        // Waits a message
	System.out.printf("Main: Configuration has been loaded: %s\n",new Date());
    }
    
    class DataSourcesLoader implements Callable<DataSourcesLoader> {
        @Override
        public DataSourcesLoader call() {
            System.out.printf("Beginnig data sources loading: %s\n",
                new Date());
                
            try {
                TimeUnit.SECONDS.sleep(4);
            }  catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            System.out.printf("Data sources loading has finished: %s\n",
                new Date());
            return this;
        }
    }
    
    class NetworkConnectionsLoader implements Callable<NetworkConnectionsLoader> {
        // public DataSourcesLoader datasourcesLoader;
        
        // public NetworkConnectionsLoader(DataSourcesLoader datasourcesLoader) {
            // this.datasourcesLoader = datasourcesLoader;
        // }
        @Override 
        public NetworkConnectionsLoader call() {
            System.out.printf("Beginning Network loading: %s\n",
                new Date());
                
            try {
                TimeUnit.SECONDS.sleep(6);
            }  catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            System.out.printf("Network establish has finished: %s\n",
                new Date());
            return this;
        }
    }
}
