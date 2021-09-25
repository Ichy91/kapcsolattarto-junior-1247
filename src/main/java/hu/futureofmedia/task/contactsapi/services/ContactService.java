package hu.futureofmedia.task.contactsapi.services;

import hu.futureofmedia.task.contactsapi.entities.Contact;
import hu.futureofmedia.task.contactsapi.entities.StatusType;
import hu.futureofmedia.task.contactsapi.model.SimpleContact;
import hu.futureofmedia.task.contactsapi.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    private List<Contact> getAllActiveContact() {
//        return contactRepository.findAllByStatusOrderByLast_nameAsc(StatusType.ACTIVE); //Not work
        return contactRepository.findAllByStatus(StatusType.ACTIVE);
    }

    public List<SimpleContact> getAllSimpleContact() {
        List<SimpleContact> simpleContacts = new ArrayList<>();
        List<Contact> contacts = getAllActiveContact();

        for(var contact: contacts) simpleContacts.add(new SimpleContact(contact));

        return simpleContacts;
    }

    public List<Contact> getContactById(UUID id) {
        return contactRepository.findAllById(Collections.singleton(id));
    }

    public void addNewContactToDb(Contact contact) {
        contactRepository.save(contact);
    }

    public void contactUpdate(Contact contactWithNewData) {
        Contact contactToUpdate = getContactById(contactWithNewData.getId()).get(0);

        contactToUpdate.setUpdated_date(new Timestamp(System.currentTimeMillis()));
        contactToUpdate.setLast_name(contactWithNewData.getLast_name());
        contactToUpdate.setFirst_name(contactWithNewData.getFirst_name());
        contactToUpdate.setEmail(contactWithNewData.getEmail());
        contactToUpdate.setPhone_number(contactWithNewData.getPhone_number());
        contactToUpdate.setCompany(contactWithNewData.getCompany());
        contactToUpdate.setNote(contactWithNewData.getNote());

        contactRepository.save(contactToUpdate);
    }

    public void contactStatusToDeleted(Contact contact) {
        contact.setStatus(StatusType.DELETED);
        contactRepository.save(contact);
    }
}
