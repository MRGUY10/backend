package com.crm.event_management_system.controller;

import com.crm.event_management_system.models.EventType;
import com.crm.event_management_system.service.EventTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/eventTypes")
public class EventTypeController {

    @Autowired
    private EventTypeService eventTypeService;

    @PostMapping
    public EventType createEventType(@RequestBody EventType eventType) {
        return eventTypeService.createEventType(eventType);
    }

    @PutMapping("/{id}")
    public EventType updateEventType(@RequestBody EventType eventType, @PathVariable Long id) {
        eventType.setId(id);
        return eventTypeService.updateEventType(eventType);
    }

    @DeleteMapping("/{id}")
    public void deleteEventType(@PathVariable Long id) {
        eventTypeService.deleteEventType(id);
    }

    @GetMapping
    public List<EventType> getAllEventTypes() {
        return eventTypeService.getAllEventTypes();
    }

    @GetMapping("/name/{name}")
    public Optional<EventType> getEventTypeByName(@PathVariable String name) {
        return eventTypeService.getEventTypeByName(name);
    }
}
