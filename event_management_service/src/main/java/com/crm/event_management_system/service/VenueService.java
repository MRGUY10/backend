package com.crm.event_management_system.service;

import com.crm.event_management_system.models.Venue;

import java.util.List;
import java.util.Optional;

public interface VenueService {
    Venue createVenue(Venue venue);
    Venue updateVenue(Venue venue);
    void deleteVenue(Long venueId);
    List<Venue> getAllVenues();
    Optional<Venue> getVenueByName(String name);
}
