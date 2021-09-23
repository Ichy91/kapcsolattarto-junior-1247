package hu.futureofmedia.task.contactsapi.services;

import hu.futureofmedia.task.contactsapi.entities.Contact;
import hu.futureofmedia.task.contactsapi.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> getAllContact() {
        return contactRepository.findAll();
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
