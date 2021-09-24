package hu.futureofmedia.task.contactsapi.services;

import hu.futureofmedia.task.contactsapi.entities.Contact;
import hu.futureofmedia.task.contactsapi.entities.StatusType;
import hu.futureofmedia.task.contactsapi.model.TemporaryContact;
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

    public void createNewContact(Contact contact) {
        contactRepository.save(contact);
    }

    public void contactUpdate(Contact contact) {
        Contact contactToUpdate = getContactById(contact.getId()).get(0);

        contactToUpdate.setUpdated_date(new Timestamp(System.currentTimeMillis()));
        contactToUpdate.setLast_name(contact.getLast_name());
        contactToUpdate.setFirst_name(contact.getFirst_name());
        contactToUpdate.setEmail(contact.getEmail());
        contactToUpdate.setPhone_number(contact.getPhone_number());
        contactToUpdate.setCompany(contact.getCompany());
        contactToUpdate.setNote(contact.getNote());

        contactRepository.save(contactToUpdate);
    }

    public void contactStatusToDeleteById(UUID id) {
        Contact contactToDelete = getContactById(id).get(0);
        contactToDelete.setStatus(StatusType.DELETED);
        contactRepository.save(contactToDelete);
    }
}
