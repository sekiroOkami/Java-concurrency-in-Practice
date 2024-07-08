package org.concurrent.chapter6.executor;

import java.util.concurrent.Executor;

public class WithInThreadExecutor implements Executor {
    @Override
    public void execute(Runnable command) {
        command.run();
    }
}
