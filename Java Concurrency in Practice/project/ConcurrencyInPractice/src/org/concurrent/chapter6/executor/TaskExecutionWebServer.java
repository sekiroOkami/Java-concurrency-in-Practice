package org.concurrent.chapter6.executor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TaskExecutionWebServer {
    private final static int NTHREADS = 100;
    private static final Executor exec = Executors.newFixedThreadPool(NTHREADS);

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        while (true) {
            final SocketChannel socketChannel = serverSocketChannel.accept().bind(new InetSocketAddress(8080));
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    // handleRequest(connection);
                }
            };
            exec.execute(task);
        }
    }
}
