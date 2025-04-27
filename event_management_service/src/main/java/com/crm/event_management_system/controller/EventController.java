package com.crm.event_management_system.controller;

import com.crm.event_management_system.exception.ResourceNotFoundException;
import com.crm.event_management_system.models.Event;
import com.crm.event_management_system.models.EventType;
import com.crm.event_management_system.models.Venue;
import com.crm.event_management_system.repository.EventRepository;
import com.crm.event_management_system.repository.EventTypeRepository;
import com.crm.event_management_system.repository.VenueRepository;
import com.crm.event_management_system.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventTypeRepository eventTypeRepository;

    @Autowired
    private VenueRepository venueRepository;


    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        return eventService.createEvent(event);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable("id") Long id, @RequestBody Event event) {
        // Ensure the EventType and Venue are already persisted
        Optional<EventType> eventTypeOpt = eventTypeRepository.findById(event.getEventType().getId());
        Optional<Venue> venueOpt = venueRepository.findById(event.getVenue().getId());

        if (!eventTypeOpt.isPresent() || !venueOpt.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }

        Event existingEvent = eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));

        existingEvent.setName(event.getName());
        existingEvent.setStartDate(event.getStartDate());
        existingEvent.setEndDate(event.getEndDate());
        existingEvent.setStartTime(event.getStartTime());
        existingEvent.setEndTime(event.getEndTime());
        existingEvent.setExpectedPerson(event.getExpectedPerson());
        existingEvent.setBudget(event.getBudget());
        existingEvent.setDescription(event.getDescription());
        existingEvent.setEventType(eventTypeOpt.get());
        existingEvent.setVenue(venueOpt.get());

        eventRepository.save(existingEvent);
        return ResponseEntity.ok(existingEvent);
    }


    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
    }

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/name/{name}")
    public Optional<Event> getEventByName(@PathVariable String name) {
        return eventService.getEventByName(name);
    }
}
