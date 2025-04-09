package com.crm.event_management_system.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @Column(name="start_date", nullable=false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate startDate;

    @Column(name="end_date", nullable=false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate endDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @Column(name="start_time", nullable=false)
    private LocalTime startTime;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @Column(name="end_time", nullable=false)
    private LocalTime endTime;

    @Column(name="expected_person", nullable=false)
    private int expectedPerson;

    @Column(name="budget", nullable=false)
    private double budget;

    @Column(name="description", nullable=false)
    private String description;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "event_type_id")
    @JsonBackReference   // This prevents re-serialization of the parent inside each event.
    private EventType eventType;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "venue_id")
    private Venue venue;
}
