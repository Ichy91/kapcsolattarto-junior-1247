package hu.futureofmedia.task.contactsapi.services;

import hu.futureofmedia.task.contactsapi.entities.Contact;
import hu.futureofmedia.task.contactsapi.model.SimpleContact;
import hu.futureofmedia.task.contactsapi.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    private List<Contact> getAllContact() {
        return contactRepository.findAll();
    }

    public List<SimpleContact> getAllSimpleContact() {
        List<SimpleContact> simpleContacts = new ArrayList<>();
        List<Contact> contacts = getAllContact();

        for(var contact: contacts) simpleContacts.add(new SimpleContact(contact));

        return simpleContacts;
    }

    public List<Contact> getContactById() {
        return null;
    }

    public void createNewContact() {

    }

    public void updateContactById() {

    }

    public void deleteContactById() {

    }
}
