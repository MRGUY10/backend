package com.crm.event_management_system.controller;

import com.crm.event_management_system.models.Venue;
import com.crm.event_management_system.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/venues")
public class VenueController {

    @Autowired
    private VenueService venueService;

    @PostMapping
    public Venue createVenue(@RequestBody Venue venue) {
        return venueService.createVenue(venue);
    }

    @PutMapping("/{id}")
    public Venue updateVenue(@RequestBody Venue venue, @PathVariable Long id) {
        venue.setId(id);
        return venueService.updateVenue(venue);
    }

    @DeleteMapping("/{id}")
    public void deleteVenue(@PathVariable Long id) {
        venueService.deleteVenue(id);
    }

    @GetMapping
    public List<Venue> getAllVenues() {
        return venueService.getAllVenues();
    }

    @GetMapping("/name/{name}")
    public Optional<Venue> getVenueByName(@PathVariable String name) {
        return venueService.getVenueByName(name);
    }
}
