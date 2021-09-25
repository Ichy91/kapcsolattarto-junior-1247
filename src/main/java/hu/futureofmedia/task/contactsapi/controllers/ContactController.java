package hu.futureofmedia.task.contactsapi.controllers;

import hu.futureofmedia.task.contactsapi.datahandler.DataHandler;
import hu.futureofmedia.task.contactsapi.entities.Company;
import hu.futureofmedia.task.contactsapi.entities.Contact;
import hu.futureofmedia.task.contactsapi.entities.StatusType;
import hu.futureofmedia.task.contactsapi.model.SimpleContact;
import hu.futureofmedia.task.contactsapi.services.CompanyService;
import hu.futureofmedia.task.contactsapi.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/service")
public class ContactController {

    private final ContactService contactService;
    private final CompanyService companyService;
    private final DataHandler dataHandler;

    @Autowired
    public ContactController(ContactService contactService, CompanyService companyService) {
        this.contactService = contactService;
        this.companyService = companyService;
        this.dataHandler = new DataHandler();
    }

    @GetMapping("/companies")
    public List<Company> getCompanies() {
        return companyService.getAllCompany();
    }

    @GetMapping("/company/{id}")
    public Company getCompanyById(@PathVariable Long id) {
        return companyService.getCompanyById(id);
    }

    @GetMapping("/statuses")
    public List<StatusType> getStatuses() {
        return new ArrayList<>(Arrays.asList(StatusType.values()));
    }

    @GetMapping("/contacts")
    public List<SimpleContact> getContacts() {
        return contactService.getAllSimpleContact();
        //TODO pagination and order by name;
    }

    @GetMapping("/contact/{id}")
    public Contact getContact(@PathVariable UUID id) {
        List<Contact> contact = contactService.getContactById(id);
        return contact.get(0);
        //TODO errorhandling NOT FOUND;
    }

    @PostMapping("/delete")
    public void contactStatusToDeleted(@RequestBody Contact contact) {
        contactService.contactStatusToDeleted(contact);
        //TODO statuscode
    }

    @PostMapping("/update")
    public void contactUpdate(@RequestBody Contact contactWithNewData) {
        contactService.contactUpdate(contactWithNewData);
        //TODO statuscode
    }

    @PostMapping("/new-contact")
    public void addNewContact(@RequestBody Map<String, Object> data) {
        Contact newContact = dataHandler.createNewContact(data);
        contactService.addNewContactToDb(newContact);
        //TODO statuscode
    }
}
