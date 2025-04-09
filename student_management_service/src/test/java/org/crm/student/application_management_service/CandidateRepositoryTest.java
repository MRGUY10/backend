package org.crm.student.application_management_service;

import org.crm.student.application_management_service.model.Candidate;
import org.crm.student.application_management_service.model.Status;
import org.crm.student.application_management_service.repository.CandidateRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class CandidateRepositoryTest {

    @Autowired
    private CandidateRepository candidateRepository;

    @Test
    public void testCreateAndSaveCandidate() {
        // Create a new Candidate instance
        Candidate candidate = new Candidate();
        candidate.setFirstName("John");
        candidate.setLastName("Doe");
        candidate.setEmail("johndoe@example.com");
        candidate.setPhoneNumber("1234567890");
        candidate.setCountry("USA");
        candidate.setCity("New York");
        candidate.setApplicationDate(LocalDateTime.now());
        candidate.setApplicationSource("Online");
        candidate.setField("Engineering");
        candidate.setStatus(Status.NEW);

        // Save the candidate
        candidate = candidateRepository.save(candidate);

        // Verify if candidate is saved
        assertNotNull(candidate.getId());
        assertEquals("John", candidate.getFirstName());
        assertEquals("Doe", candidate.getLastName());
        assertEquals("johndoe@example.com", candidate.getEmail());
    }
    @Test
    public void testStatusDefaultValue() {
        // Create a candidate with no status set
        Candidate candidate = new Candidate();
        candidate.setFirstName("Alex");
        candidate.setLastName("Brown");
        candidate.setEmail("alexbrown@example.com");
        candidate.setPhoneNumber("1230984567");
        candidate.setCountry("Canada");
        candidate.setCity("Vancouver");
        candidate.setApplicationDate(LocalDateTime.now());
        candidate.setApplicationSource("Walk-in");
        candidate.setField("Engineering");

        // Save the candidate
        candidate = candidateRepository.save(candidate);

        // Verify default status is NEW
        assertEquals(Status.NEW, candidate.getStatus());
    }

    @Test
    public void testCandidateUpdate() {
        // Create and save candidate
        Candidate candidate = new Candidate();
        candidate.setFirstName("Peter");
        candidate.setLastName("Parker");
        candidate.setEmail("peterparker@example.com");
        candidate.setPhoneNumber("1122334455");
        candidate.setCountry("USA");
        candidate.setCity("Chicago");
        candidate.setApplicationDate(LocalDateTime.now());
        candidate.setApplicationSource("Online");
        candidate.setField("Marketing");
        candidate.setStatus(Status.NEW);

        candidate = candidateRepository.save(candidate);

        // Update the candidate's city
        candidate.setCity("Los Angeles");
        candidateRepository.save(candidate);

        // Retrieve and verify updated candidate
        Candidate updatedCandidate = candidateRepository.findById(candidate.getId()).orElseThrow();
        assertEquals("Los Angeles", updatedCandidate.getCity());
    }

    @Test
    public void testCandidateDeletion() {
        // Create and save a candidate
        Candidate candidate = new Candidate();
        candidate.setFirstName("Bruce");
        candidate.setLastName("Wayne");
        candidate.setEmail("brucewayne@example.com");
        candidate.setPhoneNumber("4455667788");
        candidate.setCountry("USA");
        candidate.setCity("Gotham");
        candidate.setApplicationDate(LocalDateTime.now());
        candidate.setApplicationSource("Referral");
        candidate.setField("Business");
        candidate.setStatus(Status.NEW);

        candidate = candidateRepository.save(candidate);

        // Delete candidate
        candidateRepository.delete(candidate);

        // Verify candidate is deleted
        assertFalse(candidateRepository.findById(candidate.getId()).isPresent());
    }
}
