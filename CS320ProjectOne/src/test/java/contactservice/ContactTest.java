package contactservice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ContactTest {
    // Tests contact creation
    @Test
    void testCreateContact() {
        Contact contact = new Contact(
                "001",
                "Ethan",
                "Allen",
                "1234567890",
                "100 Cool St."
        );

        assertEquals("001", contact.getContactId());
        assertEquals("Ethan", contact.getFirstName());
        assertEquals("Allen", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("100 Cool St.", contact.getAddress());
    }

    // Id
    @Test
    void testIdCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    null,
                    "Ethan",
                    "Allen",
                    "1234567890",
                    "100 Cool St."
            );
        });
    }
    @Test
    void testIdCannotBeEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "",
                    "Ethan",
                    "Allen",
                    "1234567890",
                    "100 Cool St."
            );
        });
    }
    @Test
    void testIdCannotExceed10Characters() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345678901",
                    "Ethan",
                    "Allen",
                    "1234567890",
                    "100 Cool St."
            );
        });
    }

    // First name
    @Test
    void testFirstNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "001",
                    null,
                    "Allen",
                    "1234567890",
                    "100 Cool St."
            );
        });
    }
    @Test
    void testFirstNameCannotBeEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "001",
                    "",
                    "Allen",
                    "1234567890",
                    "100 Cool St."
            );
        });
    }
    @Test
    void testFirstNameCannotExceed10Characters() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "001",
                    "Ethan678901",
                    "Allen",
                    "1234567890",
                    "100 Cool St."
            );
        });
    }

    // Last name
    @Test
    void testLastNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "001",
                    "Ethan",
                    null,
                    "1234567890",
                    "100 Cool St."
            );
        });
    }
    @Test
    void testLastNameCannotBeEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "001",
                    "Ethan",
                    "",
                    "1234567890",
                    "100 Cool St."
            );
        });
    }
    @Test
    void testLastNameCannotExceed10Characters() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "001",
                    "Ethan",
                    "Allen678901",
                    "1234567890",
                    "100 Cool St."
            );
        });
    }

    // Phone
    @Test
    void testPhoneCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "001",
                    "Ethan",
                    "Allen",
                    null,
                    "100 Cool St."
            );
        });
    }
    @Test
    void testPhoneCannotBeEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "001",
                    "Ethan",
                    "Allen",
                    "",
                    "100 Cool St."
            );
        });
    }
    @Test
    void testPhoneCannotBeLessThan10Characters() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "001",
                    "Ethan",
                    "Allen",
                    "123456789",
                    "100 Cool St."
            );
        });
    }
    @Test
    void testPhoneCannotExceed10Characters() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "001",
                    "Ethan",
                    "Allen",
                    "12345678901",
                    "100 Cool St."
            );
        });
    }

    // Address
    @Test
    void testAddressCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "001",
                    "Ethan",
                    "Allen",
                    "1234567890",
                    null
            );
        });
    }
    @Test
    void testAddressCannotBeEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "001",
                    "Ethan",
                    "Allen",
                    "1234567890",
                    ""
            );
        });
    }
    @Test
    void testAddressCannotExceed30Characters() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "001",
                    "Ethan",
                    "Allen",
                    "1234567890",
                    "100 Cool St.3456789012345678901234567890"
            );
        });
    }

}
