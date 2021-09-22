package hu.futureofmedia.task.contactsapi.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
public class Contact {
    @Id
    private UUID id;
    private Timestamp created_date;
    private Timestamp updated_date;
    private String last_name;
    private String first_name;
    private String email;
    private String phone_number;
    private int company;
    private String note;
    private Status status;

    public UUID getId() {
        return id;
    }

    public Timestamp getCreated_date() {
        return created_date;
    }

    public Timestamp getUpdated_date() {
        return updated_date;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public int getCompany() {
        return company;
    }

    public String getNote() {
        return note;
    }

    public Status getStatus() {
        return status;
    }
}
