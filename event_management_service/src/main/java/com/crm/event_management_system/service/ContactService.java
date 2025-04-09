package com.crm.event_management_system.service;

import com.crm.event_management_system.models.Contact;

import java.util.List;

public interface ContactService {
    Contact createContact(Contact contact);
    Contact updateContact(Contact contact);
    void deleteContact(Long contactId);
    List<Contact> getAllContacts();
}
