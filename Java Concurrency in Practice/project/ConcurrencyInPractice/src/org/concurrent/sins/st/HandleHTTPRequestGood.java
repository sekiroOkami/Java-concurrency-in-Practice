package org.concurrent.sins.st;

/**
 * Suppose you have a web server that uses a thread pool to handle incoming HTTP requests.
 * Each request is handled by a thread from the pool.
 * If you execute critical business logic directly within these request-handling threads,
 * you are using alien threads for non-trivial business logic.
 */
public class HandleHTTPRequestGood {
    public void handleRequest(Request request) {
        // This is an alien thread, not dedicated to business logic
        Thread thread = Thread.currentThread();

        // Non-trivial business logic executed on alien thread
        processTransaction(request.getTransactionDetails());
    }
    private void processTransaction(TransactionDetails details) {
        /// complex business logic
    }
}
