package hu.futureofmedia.task.contactsapi.model;


import hu.futureofmedia.task.contactsapi.entities.StatusType;

public class TemporaryContact {
    private String last_name;
    private String first_name;
    private String email;
    private String phone_number;
    private Long company;
    private String note;
    private StatusType status;

    public TemporaryContact(String last_name, String first_name, String email, String phone_number, Long company, String note, StatusType status) {
        this.last_name = last_name;
        this.first_name = first_name;
        this.email = email;
        this.phone_number = phone_number;
        this.company = company;
        this.note = note;
        this.status = status;
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
}
