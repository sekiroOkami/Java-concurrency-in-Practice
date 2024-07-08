package org.concurrent.sins.st;

public class TaskHandlerBad {

    // simulate handling a task directly in the framework's thread
    public void handleTask(String taskName) {
        System.out.println("Starting task: " + taskName);
        performComplexLogic();
        System.out.println("Complete task: " + taskName);
    }

    private void performComplexLogic() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        var handler = new TaskHandlerBad();

        // Simulate handling multiple tasks
        for (int i = 1; i <= 3; i++) {
            handler.handleTask("Task" + i);
        }
    }


}
