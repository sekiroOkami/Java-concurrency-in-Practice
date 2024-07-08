package org.concurrent.sins.st;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TaskHandlerGood {
    // create a thread pool with a fixed # threads
    private final ExecutorService executor = Executors.newFixedThreadPool(3);

    public void handleTask(String taskName) {
        executor.submit(()-> {
            System.out.println("Starting task: " + taskName);
            performComplexLogic();
            System.out.println("Completed task: " + taskName);
        });
    }

    private void performComplexLogic() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void shutdown() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
                if (!executor.awaitTermination(60, TimeUnit.SECONDS))
                    System.err.println("Pool did not terminate");
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        var handler = new TaskHandlerGood();

        // simulate handling multiple tasks
        for (int i=1; i<=3; i++) {
            handler.handleTask("Task: " +i);
        }
        handler.shutdown();
    }
}
