package com.crm.event_management_system.service;

import com.crm.event_management_system.models.EventType;

import java.util.List;
import java.util.Optional;

public interface EventTypeService {
    EventType createEventType(EventType eventType);
    EventType updateEventType(EventType eventType);
    void deleteEventType(Long eventTypeId);
    List<EventType> getAllEventTypes();
    Optional<EventType> getEventTypeByName(String name);
}
