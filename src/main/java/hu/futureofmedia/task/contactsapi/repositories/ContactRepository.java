package hu.futureofmedia.task.contactsapi.repositories;

import hu.futureofmedia.task.contactsapi.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository("contactRepository")
public interface ContactRepository extends JpaRepository<Contact, UUID> {
}
