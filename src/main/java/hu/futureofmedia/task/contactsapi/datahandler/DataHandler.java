package hu.futureofmedia.task.contactsapi.datahandler;

import hu.futureofmedia.task.contactsapi.entities.Contact;
import hu.futureofmedia.task.contactsapi.entities.StatusType;

import java.util.Map;

public class DataHandler {

    public Contact createContact(Map<String, Object> data) {
        Contact newContact = new Contact();

        newContact.setLast_name(data.get("last_name").toString());
        newContact.setFirst_name(data.get("first_name").toString());
        newContact.setEmail(data.get("email").toString());
        newContact.setCompany(Long.valueOf(data.get("company").toString()));
        newContact.setStatus(StatusType.ACTIVE);

        if (data.get("phone_number") != null)
            newContact.setPhone_number(data.get("phone_number").toString());
        else newContact.setPhone_number(null);

        if (data.get("note") != null)
            newContact.setNote(data.get("note").toString());
        else newContact.setNote(null);

        return newContact;
    }
}
