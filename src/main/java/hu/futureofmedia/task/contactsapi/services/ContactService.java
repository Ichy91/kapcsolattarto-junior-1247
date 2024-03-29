package hu.futureofmedia.task.contactsapi.services;

import hu.futureofmedia.task.contactsapi.datahandler.DataHandler;
import hu.futureofmedia.task.contactsapi.entities.Contact;
import hu.futureofmedia.task.contactsapi.entities.StatusType;
import hu.futureofmedia.task.contactsapi.model.SimpleContact;
import hu.futureofmedia.task.contactsapi.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ContactService {
    private final ContactRepository contactRepository;
    private final DataHandler dataHandler;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
        this.dataHandler = new DataHandler();
    }

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

    public void addNewContactToDb(Map<String, Object> data) {
        Contact newContact = dataHandler.createNewContact(data);
        contactRepository.save(newContact);
    }

    public void contactUpdate(Contact contactWithNewData) {
        Contact contactToUpdate = getContactById(contactWithNewData.getId()).get(0);
        Contact updatedContact = dataHandler.updatingContact(contactToUpdate, contactWithNewData);

        contactRepository.save(updatedContact);
    }

    public void contactStatusToDeleted(Contact contact) {
        contact.setStatus(StatusType.DELETED);
        contactRepository.save(contact);
    }
}
