package appointmentservice;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentTest {
    //Test appointment creation
    @Test
    void testConstructor() {
        Appointment appointment = new Appointment(
                "001",
                LocalDate.now().plusDays(1),
                "Tomorrow"
        );

        assertEquals("001", appointment.getId());
        assertEquals(LocalDate.now().plusDays(1), appointment.getDate());
        assertEquals("Tomorrow", appointment.getDescription());
    }

    // Id
    @Test
    void testIdCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> new Appointment(
                null,
                LocalDate.now().plusDays(1),
                "Tomorrow"
        ));
    }
    @Test
    void testIdCannotBeBlank() {
        assertThrows(IllegalArgumentException.class, () -> new Appointment(
                " ",
                LocalDate.now().plusDays(1),
                "Tomorrow"
        ));
    }
    @Test
    void testIdCannotExceedMaxLength() {
        assertThrows(IllegalArgumentException.class, () -> new Appointment(
                "1".repeat(11),
                LocalDate.now().plusDays(1),
                "Tomorrow"
        ));
    }

    // Date
    @Test
    void testDateCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> new Appointment(
                "001",
                null,
                "Tomorrow"
        ));
    }
    @Test
    void testDateIsNotBeforeToday() {
        assertThrows(IllegalArgumentException.class, () -> new Appointment(
                "001",
                LocalDate.now().minusDays(1),
                "Tomorrow"
        ));
    }
    @Test
    void testDateSetter () {
        Appointment appointment = new Appointment(
                "001",
                LocalDate.now().plusDays(1),
                "Tomorrow"
        );

        LocalDate newDate = LocalDate.now().plusDays(10);

        assertDoesNotThrow(() -> appointment.setDate(newDate));
        assertEquals(newDate, appointment.getDate());
    }
    @Test
    void testDateSetterCannotSetNull() {
        Appointment appointment = new Appointment(
                "001",
                LocalDate.now().plusDays(1),
                "Tomorrow"
        );

        assertThrows(IllegalArgumentException.class, () ->appointment.setDate(null));
    }
    @Test
    void testDateSetterCannotSetInPast() {
        Appointment appointment = new Appointment(
                "001",
                LocalDate.now().plusDays(1),
                "Tomorrow"
        );

        assertThrows(IllegalArgumentException.class, () ->appointment.setDate(LocalDate.now().minusDays(1)));
    }

    // Description
    @Test
    void testDescriptionCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> new Appointment(
                "001",
                LocalDate.now().plusDays(1),
                null
        ));
    }
    @Test
    void testDescriptionCannotBeBlank() {
        assertThrows(IllegalArgumentException.class, () -> new Appointment(
                "001",
                LocalDate.now().plusDays(1),
                " "
        ));
    }
    @Test
    void testDescriptionCannotExceedMaxLength() {
        assertThrows(IllegalArgumentException.class, () -> new Appointment(
                "001",
                LocalDate.now().plusDays(1),
                "a".repeat(51)
        ));
    }
    @Test
    void testDescriptionSetter() {
        Appointment appointment = new Appointment(
                "001",
                LocalDate.now().plusDays(1),
                "Tomorrow"
        );

        assertDoesNotThrow(() -> appointment.setDescription("Next day"));
        assertEquals("Next day", appointment.getDescription());
    }
    @Test
    void testDescriptionSetterCannotSetNull() {
        Appointment appointment = new Appointment(
                "001",
                LocalDate.now().plusDays(1),
                "Tomorrow"
        );

        assertThrows(IllegalArgumentException.class, () ->appointment.setDescription(null));
    }
    @Test
    void testDescriptionSetterCannotSetBlank() {
        Appointment appointment = new Appointment(
                "001",
                LocalDate.now().plusDays(1),
                "Tomorrow"
        );

        assertThrows(IllegalArgumentException.class, () ->appointment.setDescription(" "));
    }
    @Test
    void testDescriptionSetterCannotSetMoreThanMaxLength() {
        Appointment appointment = new Appointment(
                "001",
                LocalDate.now().plusDays(1),
                "Tomorrow"
        );

        assertThrows(IllegalArgumentException.class, () ->appointment.setDescription("a".repeat(51)));
    }


}