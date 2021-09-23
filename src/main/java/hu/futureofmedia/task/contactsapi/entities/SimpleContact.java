package hu.futureofmedia.task.contactsapi.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class SimpleContact {

    @Id
    private UUID id;
    private String last_name;
    private String first_name;
    private Long company;
    private String email;
    private String phone_number;

    public SimpleContact() {

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
