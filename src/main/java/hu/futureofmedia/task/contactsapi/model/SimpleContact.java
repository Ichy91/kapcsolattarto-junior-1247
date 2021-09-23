package hu.futureofmedia.task.contactsapi.model;

import hu.futureofmedia.task.contactsapi.entities.Contact;

import java.util.UUID;

public class SimpleContact {
    private UUID id;
    private String last_name;
    private String first_name;
    private Long company;
    private String email;
    private String phone_number;

    public SimpleContact(Contact contact) {
        this.id = contact.getId();
        this.last_name = contact.getLast_name();
        this.first_name = contact.getFirst_name();
        this.company = contact.getCompany();
        this.email = contact.getEmail();
        this.phone_number = contact.getPhone_number();
    }

    public UUID getId() {
        return id;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public Long getCompany() {
        return company;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone_number() {
        return phone_number;
    }
}
