package com.crm.event_management_system.serviceImpl;

import com.crm.event_management_system.models.EventType;
import com.crm.event_management_system.repository.EventTypeRepository;
import com.crm.event_management_system.service.EventTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EventTypeServiceImpl implements EventTypeService {

    @Autowired
    private EventTypeRepository eventTypeRepository;

    @Override
    public EventType createEventType(EventType eventType) {
        return eventTypeRepository.save(eventType);
    }

    @Override
    public EventType updateEventType(EventType eventType) {
        return eventTypeRepository.save(eventType);
    }

    @Override
    public void deleteEventType(Long eventTypeId) {
        eventTypeRepository.deleteById(eventTypeId);
    }

    @Override
    public List<EventType> getAllEventTypes() {
        return eventTypeRepository.findAll();
    }

    @Override
    public Optional<EventType> getEventTypeByName(String name) {
        return eventTypeRepository.findByName(name);
    }
}
