package com.crm.event_management_system.controller;

import com.crm.event_management_system.models.Contact;
import com.crm.event_management_system.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping
    public Contact createContact(@RequestBody Contact contact) {
        return contactService.createContact(contact);
    }

    @PutMapping("/{id}")
    public Contact updateContact(@RequestBody Contact contact, @PathVariable Long id) {
        contact.setId(id);
        return contactService.updateContact(contact);
    }

    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
    }

    @GetMapping
    public List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    @GetMapping("/name/{name}")
    public List<Contact> getContactByName(@PathVariable String name) {
        return contactService.getAllContacts().stream()
                .filter(contact -> contact.getFirstName().equalsIgnoreCase(name) || contact.getLastName().equalsIgnoreCase(name))
                .toList();
    }
}
