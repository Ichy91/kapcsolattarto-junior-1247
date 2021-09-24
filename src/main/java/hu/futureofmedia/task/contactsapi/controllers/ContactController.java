package hu.futureofmedia.task.contactsapi.controllers;

import hu.futureofmedia.task.contactsapi.entities.Contact;
import hu.futureofmedia.task.contactsapi.model.SimpleContact;
import hu.futureofmedia.task.contactsapi.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("api/service")
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/contacts")
    public List<SimpleContact> getContacts() {
        return contactService.getAllSimpleContact();
    }

    @GetMapping("/contact/{id}")
    public Contact getContact(@PathVariable UUID id) {
        List<Contact> contact = contactService.getContactById(id);
        return contact.get(0);
    }

    @PostMapping("/delete")
    public void contactStatusToDelete(@RequestBody Contact contact) {
        contactService.contactStatusToDeleteById(contact);
    }

    @PostMapping("/update")
    public void contactUpdate(@RequestBody Contact contact) {
        contactService.contactUpdate(contact);
    }
}
