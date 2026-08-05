package taskservice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TaskTest {

    // Test task creation
    @Test
    void testConstructor() {
        Task task = new Task(
                "001",
                "Clean room",
                "Pickup the floor."
        );

        assertEquals("001", task.getTaskId());
        assertEquals("Clean room", task.getTaskName());
        assertEquals("Pickup the floor.", task.getTaskDescription());
    }

    // Id
    @Test
    void testIdCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> new Task(
                null,
                "Clean room",
                "Pickup the floor."
        ));
    }
    @Test
    void testIdCannotBeEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new Task(
                "",
                "Clean room",
                "Pickup the floor."
        ));
    }
    @Test
    void testIdCannotExceedMaxLength() {
        assertThrows(IllegalArgumentException.class, () -> new Task(
                "12345678901",
                "Clean room",
                "Pickup the floor."
        ));
    }

    // Test name
    @Test
    void testNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> new Task(
                "001",
                null,
                "Pickup the floor."
        ));
    }
    @Test
    void testNameCannotBeEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new Task(
                "001",
                "",
                "Pickup the floor."
        ));
    }
    @Test
    void testNameCannotExceedMaxLength() {
        assertThrows(IllegalArgumentException.class, () -> new Task(
                "001",
                "123456789012345678901",
                "Pickup the floor."
        ));
    }
    @Test
    void testNameSetter() {
        Task task = new Task(
                "001",
                "Clean room",
                "Pickup the floor."
        );

        assertThrows(IllegalArgumentException.class, () -> task.setTaskName(null));
        assertThrows(IllegalArgumentException.class, () -> task.setTaskName(""));
        assertThrows(IllegalArgumentException.class, () -> task.setTaskName("123456789012345678901"));
    }

    // Test description
    @Test
    void testDescriptionCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> new Task(
                "001",
                "Clean room",
                null
        ));
    }
    @Test
    void testDescriptionCannotBeEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new Task(
                "001",
                "Clean room",
                ""
        ));
    }
    @Test
    void testDescriptionCannotExceedMaxLength() {
        assertThrows(IllegalArgumentException.class, () -> new Task(
                "001",
                "Clean room",
                "123456789012345678901234567890123456789012345678901"
        ));
    }
    @Test
    void testDescriptionSetter() {
        Task task = new Task(
                "001",
                "Clean room",
                "Pickup the floor."
        );

        assertThrows(IllegalArgumentException.class, () -> task.setTaskDescription(null));
        assertThrows(IllegalArgumentException.class, () -> task.setTaskDescription(""));
        assertThrows(IllegalArgumentException.class, () -> task.setTaskDescription("123456789012345678901234567890123456789012345678901"));
    }
}