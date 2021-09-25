package hu.futureofmedia.task.contactsapi.datahandler;

import hu.futureofmedia.task.contactsapi.entities.Contact;
import hu.futureofmedia.task.contactsapi.entities.StatusType;

import java.sql.Timestamp;
import java.util.Map;

public class DataHandler {

    public Contact createNewContact(Map<String, Object> data) {
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

    public Contact updatingContact(Contact contactToUpdate, Contact contactWithNewData) {
        contactToUpdate.setUpdated_date(new Timestamp(System.currentTimeMillis()));
        contactToUpdate.setLast_name(contactWithNewData.getLast_name());
        contactToUpdate.setFirst_name(contactWithNewData.getFirst_name());
        contactToUpdate.setEmail(contactWithNewData.getEmail());
        contactToUpdate.setPhone_number(contactWithNewData.getPhone_number());
        contactToUpdate.setCompany(contactWithNewData.getCompany());
        contactToUpdate.setNote(contactWithNewData.getNote());

        return contactToUpdate;
    }

    //TODO validation;
}
