package com.crm.event_management_system.repository;

import com.crm.event_management_system.models.EventType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EventTypeRepository extends JpaRepository<EventType, Long> {
    Optional<EventType> findByName(String name);
}

