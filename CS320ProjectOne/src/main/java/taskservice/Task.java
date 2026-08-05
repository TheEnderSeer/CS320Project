package taskservice;

public class Task {
    private final String taskId;
    private String taskName;
    private String taskDescription;

    private static final int MAX_ID_LENGTH = 10;
    private static final int MAX_NAME_LENGTH = 20;
    private static final int MAX_DESCRIPTION_LENGTH = 50;

    // Constructor
    public Task(String taskId, String taskName, String taskDescription) {
        if (taskId == null || taskId.isEmpty() || taskId.length() > MAX_ID_LENGTH) {
            throw new IllegalArgumentException(String.format(
                    "Task id '%s' is invalid. Task id cannot be null, empty, or more than %s characters.",
                    taskId,
                    MAX_ID_LENGTH
            ));
        }
        if (taskName == null || taskName.isEmpty() || taskName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format(
                    "Task name '%s' is invalid. Task name cannot be null, empty, or more than %s characters.",
                    taskName,
                    MAX_NAME_LENGTH
            ));
        }
        if (taskDescription == null || taskDescription.isEmpty() || taskDescription.length() > MAX_DESCRIPTION_LENGTH) {
            throw new IllegalArgumentException(String.format(
                    "Task description '%s' is invalid. Task description cannot be null, empty, or more than %s characters.",
                    taskDescription,
                    MAX_DESCRIPTION_LENGTH
            ));
        }

        this.taskId = taskId;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
    }

    // Getters and Setters
    public String getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }
    public void setTaskName(String taskName) {
        if (taskName == null || taskName.isEmpty() || taskName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("Task name cannot be null, empty, or more than %s characters",
                    MAX_NAME_LENGTH
            ));
        }

        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }
    public void setTaskDescription(String taskDescription) {
        if (taskDescription == null || taskDescription.isEmpty() || taskDescription.length() > MAX_DESCRIPTION_LENGTH) {
            throw new IllegalArgumentException(String.format("Task description cannot be null, empty, or more than %s characters",
                    MAX_DESCRIPTION_LENGTH
            ));
        }

        this.taskDescription = taskDescription;
    }



}
