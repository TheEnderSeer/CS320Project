package contactservice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContactServiceTest {
    private ContactService contactService;

    // Setup service
    @BeforeEach
    void setUp() {
        contactService = new ContactService();
    }

    // Tests get contact
    @Test
    void testGetContact() {
        Contact contact = new Contact(
                "001",
                "Ethan",
                "Allen",
                "1234567890",
                "Cool 100 St."
        );

        contactService.addContact(contact);

        Contact result = contactService.getContact("001");

        assertEquals("001", result.getContactId());
        assertEquals("Ethan", result.getFirstName());
    }
    @Test
    void testGetNonExistingContact() {
        Contact contact = new Contact(
                "001",
                "Ethan",
                "Allen",
                "1234567890",
                "Cool 100 St."
        );

        contactService.addContact(contact);

        assertThrows(IllegalArgumentException.class, () -> {
            contactService.getContact("002");
        });
    }

    // Tests add contact
    @Test
    void testAddContact() {
        Contact contact = new Contact(
                "001",
                "Ethan",
                "Allen",
                "1234567890",
                "Cool 100 St."
        );

        assertDoesNotThrow(() -> {
            contactService.addContact(contact);
        });
    }

    // Test duplicate contact
    @Test
    void testContactIdCannotBeDuplicate() {
        Contact contact1 = new Contact(
                "001",
                "Ethan",
                "Allen",
                "1234567890",
                "Cool 100 St."
        );
        Contact contact2 = new Contact(
                "001",
                "John",
                "Doe",
                "1234567899",
                "Cool 101 St."
        );

        contactService.addContact(contact1);

        assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(contact2);
        });
    }

    // Test delete contact
    @Test
    void testDeleteContact() {
        Contact contact = new Contact(
                "001",
                "Ethan",
                "Allen",
                "1234567890",
                "Cool 100 St."
        );

        contactService.addContact(contact);

        assertDoesNotThrow(() -> {
            contactService.deleteContact("001");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.getContact("001");
        });
    }
    @Test
    void testDeleteNonExistingContact() {

        assertThrows(IllegalArgumentException.class, () -> {
            contactService.deleteContact("001");
        });
    }

    // Test update fields
    @Test
    void testUpdateFirstName() {
        Contact contact = new Contact(
                "001",
                "Ethan",
                "Allen",
                "1234567890",
                "Cool 100 St."
        );

        contactService.addContact(contact);
        contactService.updateFirstName("001", "John");

        assertEquals("John", contactService.getContact("001").getFirstName());
    }
    @Test
    void testUpdateLastName() {
        Contact contact = new Contact(
                "001",
                "Ethan",
                "Allen",
                "1234567890",
                "Cool 100 St."
        );

        contactService.addContact(contact);
        contactService.updateLastName("001", "Doe");

        assertEquals("Doe", contactService.getContact("001").getLastName());
    }
    @Test
    void testUpdatePhone() {
        Contact contact = new Contact(
                "001",
                "Ethan",
                "Allen",
                "1234567890",
                "Cool 100 St."
        );

        contactService.addContact(contact);
        contactService.updatePhone("001", "0987654321");

        assertEquals("0987654321", contactService.getContact("001").getPhone());
    }
    @Test
    void testUpdateAddress() {
        Contact contact = new Contact(
                "001",
                "Ethan",
                "Allen",
                "1234567890",
                "Cool 100 St."
        );

        contactService.addContact(contact);
        contactService.updateAddress("001", "Cool 101 St.");

        assertEquals("Cool 101 St.", contactService.getContact("001").getAddress());
    }
}
