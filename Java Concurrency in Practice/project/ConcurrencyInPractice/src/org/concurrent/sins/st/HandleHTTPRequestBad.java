package org.concurrent.sins.st;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HandleHTTPRequestBad {
    // Dedicated thread pool for business logic
    ExecutorService businessLogicExecutor = Executors.newFixedThreadPool(10);

    public void handleRequest(Request request) {

        // Offload non-trivial business logic to dedicated thread pool
        businessLogicExecutor.submit(() -> processTransaction(request.getTransactionDetails()));

        // More request handling
    }
    private void processTransaction(TransactionDetails details) {
        /// complex business logic
    }
}
