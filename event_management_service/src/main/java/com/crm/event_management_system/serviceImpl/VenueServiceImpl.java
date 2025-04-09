package com.crm.event_management_system.serviceImpl;

import com.crm.event_management_system.models.Venue;
import com.crm.event_management_system.repository.VenueRepository;
import com.crm.event_management_system.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VenueServiceImpl implements VenueService {

    @Autowired
    private VenueRepository venueRepository;

    @Override
    public Venue createVenue(Venue venue) {
        return venueRepository.save(venue);
    }

    @Override
    public Venue updateVenue(Venue venue) {
        return venueRepository.save(venue);
    }

    @Override
    public void deleteVenue(Long venueId) {
        venueRepository.deleteById(venueId);
    }

    @Override
    public List<Venue> getAllVenues() {
        return venueRepository.findAll();
    }

    @Override
    public Optional<Venue> getVenueByName(String name) {
        return venueRepository.findByName(name);
    }
}
