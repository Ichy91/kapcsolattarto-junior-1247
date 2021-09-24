package hu.futureofmedia.task.contactsapi.controllers;

import hu.futureofmedia.task.contactsapi.entities.Company;
import hu.futureofmedia.task.contactsapi.entities.Contact;
import hu.futureofmedia.task.contactsapi.model.SimpleContact;
import hu.futureofmedia.task.contactsapi.services.CompanyService;
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
    private final CompanyService companyService;

    @Autowired
    public ContactController(ContactService contactService, CompanyService companyService) {
        this.contactService = contactService;
        this.companyService = companyService;
    }

    @GetMapping("/companies")
    public List<Company> getCompanies() {
        return companyService.getAllCompany();
    }

    @GetMapping("/company/{id}")
    public Company getCompanyById(@PathVariable Long id) {
        return companyService.getCompanyById(id);
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
