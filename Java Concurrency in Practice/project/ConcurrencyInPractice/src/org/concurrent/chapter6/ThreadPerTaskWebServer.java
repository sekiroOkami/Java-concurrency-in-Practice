package org.concurrent.chapter6;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

public class ThreadPerTaskWebServer {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(8080));
        while (true) {
            final SocketChannel socketChannel = serverSocketChannel.accept();
            var task = new Runnable() {
                @Override
                public void run() {
//                    handleRequest(connection);
                }
            };
            Executors.newCachedThreadPool().submit(task);
        }
    }
}
