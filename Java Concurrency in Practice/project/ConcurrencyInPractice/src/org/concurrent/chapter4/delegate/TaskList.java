package org.concurrent.chapter4.delegate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TaskList {
    // Delegate the thread safety to this class, avoiding the need for explicit synchronization in 'TaskList' class
    private final List<Task> tasks = new CopyOnWriteArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    public List<Task> getTasks() {
        return new ArrayList<>(tasks);// Return a copy to maintain thread safety
    }
}
