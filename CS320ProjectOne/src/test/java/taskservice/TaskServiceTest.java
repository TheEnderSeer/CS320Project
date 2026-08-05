package taskservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {
    private TaskService taskService;

    // Setup service
    @BeforeEach
    void setUp() {
        taskService = new TaskService();
    }

    // Test get task
    @Test
    void testGetTask() {
        Task task = new Task(
                "001",
                "Clean room",
                "Pickup the floor."
        );
        taskService.addTask(task);

        Task result = taskService.getTask("001");
        assertEquals("001", result.getTaskId());
        assertEquals("Clean room", result.getTaskName());
        assertEquals("Pickup the floor.", result.getTaskDescription());
    }

    // Test get non-existing task
    @Test
    void testGetNonExistingTask() {
        Task task = new Task(
                "001",
                "Clean room",
                "Pickup the floor."
        );

        taskService.addTask(task);

        assertThrows(IllegalArgumentException.class, () -> taskService.getTask("002"));
    }

    // Test add task
    @Test
    void testAddTask() {
        Task task = new Task(
                "001",
                "Clean room",
                "Pickup the floor."
        );

        assertDoesNotThrow(() -> taskService.addTask(task));
    }

    // Test duplicate task
    @Test
    void testDuplicateTaskId() {
        Task task1 = new Task(
                "001",
                "Clean room",
                "Pickup the floor."
        );
        taskService.addTask(task1);

        Task task2 = new Task(
                "001",
                "Clean kitchen",
                "Mop the floor."
        );
        assertThrows(IllegalArgumentException.class, () -> taskService.addTask(task2));
    }

    // Test delete task
    @Test
    void testDeleteTask() {
        Task task = new Task(
                "001",
                "Clean room",
                "Pickup the floor."
        );
        taskService.addTask(task);

        assertDoesNotThrow(() -> taskService.deleteTask("001"));
        assertThrows(IllegalArgumentException.class, () -> taskService.getTask("001"));
    }
    @Test
    void testDeleteNonExistingTask() {
        Task task = new Task(
                "001",
                "Clean room",
                "Pickup the floor."
        );
        taskService.addTask(task);

        assertThrows(IllegalArgumentException.class, () -> taskService.deleteTask("002"));
    }

    // Test update fields
    @Test
    void testUpdateName() {
        Task task = new Task(
                "001",
                "Clean room",
                "Pickup the floor."
        );
        taskService.addTask(task);

        assertDoesNotThrow(() -> taskService.updateTaskName("001", "Clean kitchen"));
        assertEquals("Clean kitchen", taskService.getTask("001").getTaskName());
    }
    @Test
    void testUpdateDescription() {
        Task task = new Task(
                "001",
                "Clean room",
                "Pickup the floor."
        );
        taskService.addTask(task);

        assertDoesNotThrow(() -> taskService.updateTaskDescription("001", "Fold the laundry."));
        assertEquals("Fold the laundry.", taskService.getTask("001").getTaskDescription());
    }

}