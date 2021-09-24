package hu.futureofmedia.task.contactsapi.datahandler;

import hu.futureofmedia.task.contactsapi.entities.Contact;

import java.util.HashMap;
import java.util.Map;

public class DataHandler {
    private Map<String, String> map;

    public DataHandler() {
        this.map = new HashMap<>();
    }

    public Map<String, String> createOneContactToJson(Contact contact) {
        map.put("id", contact.getId().toString());
        map.put("last_name", contact.getLast_name());
        map.put("first_name", contact.getFirst_name());
        map.put("company", contact.getCompany().toString());
        map.put("email", contact.getEmail());
        map.put("phone_number", contact.getPhone_number());
        map.put("note", contact.getNote());
        map.put("created_date", contact.getCreated_date().toString());

        if (contact.getUpdated_date() == null)
            map.put("updated_date", null);
        else
            map.put("updated_date", contact.getUpdated_date().toString());

        return map;
    }
}
