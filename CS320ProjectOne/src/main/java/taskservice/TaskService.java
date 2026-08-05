package taskservice;

import java.util.HashMap;

public class TaskService {
    private final HashMap<String, Task> tasks;

    // Constructor
    public TaskService() {
        tasks = new HashMap<>();
    }

    // Get task
    public Task getTask(String taskId) {
        Task task = tasks.get(taskId);

        if (task == null) {
            throw new IllegalArgumentException("Task doesn't exist.");
        }

        return task;
    }

    // Add task
    public void addTask(Task task) {
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Task already exists.");
        }

        tasks.put(task.getTaskId(), task);
    }

    // Delete task
    public void deleteTask(String taskId) {
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task doesn't exist.");
        }

        tasks.remove(taskId);
    }

    // Update task name
    public void updateTaskName(String taskId, String taskName) {
        getTask(taskId).setTaskName(taskName);
    }

    // Update task description
    public void updateTaskDescription(String taskId, String taskDescription) {
        getTask(taskId).setTaskDescription(taskDescription);
    }

}
