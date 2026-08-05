package contactservice;

import java.util.HashMap;

public class ContactService {
    private final HashMap<String, Contact> contacts;

    // Constructor
    public ContactService() {
        contacts = new HashMap<>();
    }

    // Get contact
    public Contact getContact(String contactId) {
        Contact contact = contacts.get(contactId);

        if (contact == null) {
            throw new IllegalArgumentException("Contact doesn't exist");
        }

        return contact;
    }

    // Add contact
    public void addContact(Contact contact) {
        if(contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact already exists");
        }

        contacts.put(contact.getContactId(), contact);
    }

    // Delete contact
    public void deleteContact(String contactId) {
        getContact(contactId);
        contacts.remove(contactId);
    }

    // Update first name
    public void updateFirstName(String contactId, String firstName) {
        getContact(contactId).setFirstName(firstName);
    }

    // Update last name
    public void updateLastName(String contactId, String lastName) {
        getContact(contactId).setLastName(lastName);
    }

    // Update phone number
    public void updatePhone(String contactId, String phone) {
        getContact(contactId).setPhone(phone);
    }

    // Update address
    public void updateAddress(String contactId, String address) {
        getContact(contactId).setAddress(address);
    }
}
