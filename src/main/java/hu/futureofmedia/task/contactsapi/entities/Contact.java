package hu.futureofmedia.task.contactsapi.entities;

import javax.persistence.*;
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
    private Long company;
    private String note;

    @Enumerated(EnumType.STRING)
    private StatusType status;


    public Contact() {

    }

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

    public Long getCompany() {
        return company;
    }

    public String getNote() {
        return note;
    }

    public StatusType getStatus() {
        return status;
    }

    public void setUpdated_date(Timestamp updated_date) {
        this.updated_date = updated_date;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setCompany(Long company) {
        this.company = company;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }
}
