package com.crm.event_management_system.serviceImpl;

import com.crm.event_management_system.models.EventType;
import com.crm.event_management_system.models.Venue;
import com.crm.event_management_system.repository.EventRepository;
import com.crm.event_management_system.repository.EventTypeRepository;
import com.crm.event_management_system.repository.VenueRepository;
import com.crm.event_management_system.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crm.event_management_system.models.Event;
import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private VenueRepository venueRepository;

    @Autowired
    private EventTypeRepository eventTypeRepository;

    @Override
    public Event createEvent(Event event) {
        Venue venue = venueRepository.findById(event.getVenue().getId()).orElseThrow(() -> new RuntimeException("Venue not found"));
        EventType eventType = eventTypeRepository.findById(event.getEventType().getId()).orElseThrow(() -> new RuntimeException("EventType not found"));

        event.setVenue(venue);
        event.setEventType(eventType);
        return eventRepository.save(event);
    }

    @Override
    public Event updateEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public void deleteEvent(Long eventId) {
        eventRepository.deleteById(eventId);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Optional<Event> getEventByName(String name) {
        return eventRepository.findByName(name);
    }
}
