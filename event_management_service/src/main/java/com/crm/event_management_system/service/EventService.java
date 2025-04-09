package com.crm.event_management_system.service;

import com.crm.event_management_system.models.Event;

import java.util.List;
import java.util.Optional;

public interface EventService {
    Event createEvent(Event event);
    Event updateEvent(Event event);
    void deleteEvent(Long eventId);
    List<Event> getAllEvents();
    Optional<Event> getEventByName(String name);
}
