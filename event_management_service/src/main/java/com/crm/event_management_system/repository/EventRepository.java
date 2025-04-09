package com.crm.event_management_system.repository;

import com.crm.event_management_system.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Long> {
    Optional<Event> findByName(String name);
}

