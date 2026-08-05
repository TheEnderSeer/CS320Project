package contactservice;

public class Contact {
    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    // Constructor
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        if (contactId == null || contactId.isEmpty() || contactId.length() > 10) {
            throw new IllegalArgumentException("id cannot be null, empty, or more than 10 characters");
        }
        if (firstName == null || firstName.isEmpty() || firstName.length() > 10) {
            throw new IllegalArgumentException("firstName cannot be null, empty, or  more than 10 characters");
        }
        if (lastName == null || lastName.isEmpty() || lastName.length() > 10) {
            throw new IllegalArgumentException("lastName cannot be null, empty, or  more than 10 characters");
        }
        if (phone == null || phone.length() != 10) {
            throw new IllegalArgumentException("phone must be 10 characters");
        }
        if (address == null || address.isEmpty() || address.length() > 30) {
            throw new IllegalArgumentException("address cannot be null, empty, or more than 30 characters");
        }

        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Getters and Setters
    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
