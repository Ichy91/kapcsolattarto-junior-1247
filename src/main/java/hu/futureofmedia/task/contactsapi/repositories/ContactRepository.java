package hu.futureofmedia.task.contactsapi.repositories;

import hu.futureofmedia.task.contactsapi.entities.Contact;

import hu.futureofmedia.task.contactsapi.entities.StatusType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository("contactRepository")
public interface ContactRepository extends JpaRepository<Contact, UUID> {

//    List<Contact> findAllByStatusOrderByLast_nameAsc(StatusType status); //Not work
    List<Contact> findAllByStatus(StatusType status);
}
