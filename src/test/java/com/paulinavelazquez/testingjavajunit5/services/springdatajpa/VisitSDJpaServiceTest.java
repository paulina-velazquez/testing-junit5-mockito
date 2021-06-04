package com.paulinavelazquez.testingjavajunit5.services.springdatajpa;

import com.paulinavelazquez.testingjavajunit5.model.Visit;
import com.paulinavelazquez.testingjavajunit5.repositories.VisitRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VisitSDJpaServiceTest {

    @Mock
    VisitRepository visitRepository;

    @InjectMocks
    VisitSDJpaService service;

    @DisplayName("Test Find All")
    @Test
    void findAll() {
        Visit visit = new Visit();
        Set<Visit> visits = new HashSet<Visit>();
        visits.add(visit);
        when(visitRepository.findAll()).thenReturn(visits);
        Set<Visit> foundVisits = service.findAll();
        assertNotNull(foundVisits);
        // Junit5
        assertEquals(1, foundVisits.size());
        // AssertJ
        assertThat(foundVisits).hasSize(1);
        verify(visitRepository).findAll();
    }

    @DisplayName("Test Find By Id")
    @Test
    void findById() {
        Visit visit = new Visit();
        when(visitRepository.findById(anyLong())).thenReturn(Optional.of(visit));
        Visit foundVisit = service.findById(1L);
        // JUnit5
        assertNotNull(foundVisit);
        // AssertJ
        assertThat(foundVisit).isNotNull();
        verify(visitRepository).findById(1L);
    }

    @DisplayName("Test Save")
    @Test
    void save() {
        Visit visit = new Visit(); // Returning this object
        when(visitRepository.save(any(Visit.class))).thenReturn(visit);
        Visit savedVisit = service.save(new Visit()); // Saving another new object
        // JUnit 5
        assertNotNull(savedVisit);
        // Assertj
        assertThat(savedVisit).isNotNull();
        verify(visitRepository).save(any(Visit.class));
    }

    @DisplayName("Test Delete")
    @Test
    void delete() {
        Visit visit = new Visit();
        service.delete(visit);
        verify(visitRepository).delete(any(Visit.class));
    }

    @DisplayName("Test Delete By Id")
    @Test
    void deleteById() {
        service.deleteById(1L);
        verify(visitRepository).deleteById(anyLong());
    }
}