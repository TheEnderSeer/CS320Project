package appointmentservice;

import java.time.LocalDate;
import java.util.HashMap;

public class AppointmentService {
    private final HashMap<String, Appointment> appointments;

    // Constructor
    public AppointmentService() {
        appointments = new HashMap<>();
    }

    // Get appointment
    public Appointment getAppointment(String id) {
        Appointment appointment = appointments.get(id);

        if (appointment == null) {
            throw new IllegalArgumentException("Appointment with id " + id + " does not exist");
        }

        return appointment;
    }

    // Add appointment
    public void addAppointment(Appointment appointment) {
        if (appointment == null) {
            throw new IllegalArgumentException("Appointment cannot be null");
        }
        if (appointments.containsKey(appointment.getId())) {
            throw new IllegalArgumentException("Appointment with id " + appointment.getId() + " already exists");
        }

        appointments.put(appointment.getId(), appointment);
    }

    // Delete appointment
    public void deleteAppointment(String id) {
        if (!appointments.containsKey(id)) {
            throw new IllegalArgumentException("Appointment with id " + id + " does not exist");
        }

        appointments.remove(id);
    }

    // Update appointment date
    public void updateAppointmentDate(String id, LocalDate date) {
        getAppointment(id).setDate(date);
    }

    // Update appointment description
    public void updateAppointmentDescription(String id, String description) {
        getAppointment(id).setDescription(description);
    }

}
