package appointmentservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentServiceTest {
    private AppointmentService appointmentService;

    // Setup service
    @BeforeEach
    void setUp() {
        appointmentService = new AppointmentService();
    }

    // Test get appointment
    @Test
    void testGetAppointment() {
        Appointment appointment = new Appointment(
                "001",
                LocalDate.now().plusDays(1),
                "Tomorrow"
        );
        appointmentService.addAppointment(appointment);

        Appointment result = appointmentService.getAppointment(appointment.getId());
        assertEquals("001", result.getId());
        assertEquals(LocalDate.now().plusDays(1), result.getDate());
        assertEquals("Tomorrow", result.getDescription());
    }

    // Test get non-existing appointment
    @Test
    void testGetNonExistingAppointment() {
        Appointment appointment = new Appointment(
                "001",
                LocalDate.now().plusDays(1),
                "Tomorrow"
        );
        appointmentService.addAppointment(appointment);

        assertThrows(IllegalArgumentException.class, () -> appointmentService.getAppointment("002"));
    }

    // Test add appointment
    @Test
    void testAddAppointment() {
        Appointment appointment = new Appointment(
                "001",
                LocalDate.now().plusDays(1),
                "Tomorrow"
        );

        assertDoesNotThrow(() -> appointmentService.addAppointment(appointment));
    }
    @Test
    void testDuplicateAppointmentId() {
        Appointment appointment1 = new Appointment(
                "001",
                LocalDate.now().plusDays(1),
                "Tomorrow"
        );
        appointmentService.addAppointment(appointment1);

        Appointment appointment2 = new Appointment(
                "001",
                LocalDate.now().plusDays(10),
                "Ten days later"
        );
        assertThrows(IllegalArgumentException.class, () -> appointmentService.addAppointment(appointment2));
    }
    @Test
    void testCannotAddNullAppointment() {
        assertThrows(IllegalArgumentException.class, () -> appointmentService.addAppointment(null));
    }

    // Test delete appointment
    @Test
    void testDeleteAppointment() {
        Appointment appointment = new Appointment(
                "001",
                LocalDate.now().plusDays(1),
                "Tomorrow"
        );
        appointmentService.addAppointment(appointment);

        assertDoesNotThrow(() -> appointmentService.deleteAppointment(appointment.getId()));
        assertThrows(IllegalArgumentException.class, () -> appointmentService.getAppointment(appointment.getId()));
    }
    @Test
    void testDeleteNonExistingAppointment() {
        Appointment appointment = new Appointment(
                "001",
                LocalDate.now().plusDays(1),
                "Tomorrow"
        );
        appointmentService.addAppointment(appointment);

        assertThrows(IllegalArgumentException.class, () -> appointmentService.deleteAppointment("002"));
    }

    // Test update fields
    @Test
    void testUpdateDate() {
        Appointment appointment = new Appointment(
                "001",
                LocalDate.now().plusDays(1),
                "Tomorrow"
        );
        appointmentService.addAppointment(appointment);

        assertDoesNotThrow(() -> appointmentService.updateAppointmentDate(appointment.getId(), LocalDate.now().plusDays(10)));
        assertEquals(LocalDate.now().plusDays(10), appointmentService.getAppointment(appointment.getId()).getDate());
    }
    @Test
    void testUpdateDescription() {
        Appointment appointment = new Appointment(
                "001",
                LocalDate.now().plusDays(1),
                "Tomorrow"
        );
        appointmentService.addAppointment(appointment);

        assertDoesNotThrow(() -> appointmentService.updateAppointmentDescription(appointment.getId(), "Next day"));
        assertEquals("Next day", appointmentService.getAppointment(appointment.getId()).getDescription());
    }


}