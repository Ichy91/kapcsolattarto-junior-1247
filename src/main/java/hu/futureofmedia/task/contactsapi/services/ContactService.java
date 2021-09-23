package hu.futureofmedia.task.contactsapi.services;

import hu.futureofmedia.task.contactsapi.entities.Contact;
import hu.futureofmedia.task.contactsapi.entities.StatusType;
import hu.futureofmedia.task.contactsapi.model.SimpleContact;
import hu.futureofmedia.task.contactsapi.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.OrderBy;
import java.util.ArrayList;
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

    public Contact getContactById(UUID uuid) {
        return contactRepository.getById(uuid);
    }

    public void createNewContact() {

    }

    public void updateContactById() {

    }

    public void deleteContactById(UUID uuid) {
        Contact contactToDelete = getContactById(uuid);
        contactToDelete.setStatus(StatusType.DELETED);
        contactRepository.save(contactToDelete);
    }
}
