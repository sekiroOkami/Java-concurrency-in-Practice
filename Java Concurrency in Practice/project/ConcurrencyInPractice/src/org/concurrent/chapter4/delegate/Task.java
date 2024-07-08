package org.concurrent.chapter4.delegate;

public class Task {
    private  final String description;

    public Task(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Task{" + "description='" + description + '\'' + '}';
    }
}
