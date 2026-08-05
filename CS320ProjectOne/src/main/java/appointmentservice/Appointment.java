package appointmentservice;

import java.time.LocalDate;

public class Appointment {
    private final String id;
    private LocalDate date;
    private String description;

    private static final int MAX_ID_LENGTH = 10;
    private static final int MAX_DESCRIPTION_LENGTH = 50;

    // Constructor
    public Appointment(String id, LocalDate date, String description) {
        // Id
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("ID cannot be null or blank");
        }
        if (id.length() > MAX_ID_LENGTH) {
            throw new IllegalArgumentException("ID length cannot be longer than " + MAX_ID_LENGTH);
        }

        // Date
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        if (date.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Date cannot be before now");
        }

        // Description
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Description cannot be null or blank");
        }
        if (description.length() > MAX_DESCRIPTION_LENGTH) {
            throw new IllegalArgumentException("Description length cannot be longer than " + MAX_DESCRIPTION_LENGTH);
        }

        this.id = id;
        this.date = date;
        this.description = description;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        if (date.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Date cannot be before now");
        }

        this.date = date;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Description cannot be null or blank");
        }
        if (description.length() > MAX_DESCRIPTION_LENGTH) {
            throw new IllegalArgumentException("Description length cannot be longer than " + MAX_DESCRIPTION_LENGTH);
        }

        this.description = description;
    }
}
