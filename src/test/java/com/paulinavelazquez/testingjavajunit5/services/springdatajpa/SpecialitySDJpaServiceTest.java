package com.paulinavelazquez.testingjavajunit5.services.springdatajpa;

import com.paulinavelazquez.testingjavajunit5.model.Speciality;
import com.paulinavelazquez.testingjavajunit5.repositories.SpecialityRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SpecialitySDJpaServiceTest {

    @Mock
    SpecialityRepository specialityRepository;

    @InjectMocks
    SpecialitySDJpaService service;

    @Test
    void testDelete() {
        service.delete(new Speciality());
    }

    // Argument Matcher (returns void)
    @Test
    void testDeleteByObject() {
        Speciality speciality = new Speciality();
        service.delete(speciality);
        verify(specialityRepository).delete(any(Speciality.class));
    }

    // Return value from mock (returns Obj)
    @Test
    void findByIdTestExpectValue() {
        Speciality speciality = new Speciality();
        when(specialityRepository.findById(1L)).thenReturn(Optional.of(speciality));
        Speciality foundSpeciality = service.findById(1L);
        // JUnit5
        assertNotNull(foundSpeciality);
        // AssertJ
        assertThat(foundSpeciality).isNotNull();
        verify(specialityRepository, times(1)).findById(1l);
    }

    // Verify
    @Test
    void deleteByIdAndVerify() {
        // values must match
        service.deleteById(1L);
        verify(specialityRepository).deleteById(1L);
    }

    @Test
    void deleteByIdTwice() {
        service.deleteById(1L);
        service.deleteById(1L);
        verify(specialityRepository, times(2)).deleteById(1L);
    }

    @Test
    void deleteByIdAtLeast() {
        service.deleteById(1L);
        service.deleteById(1L);
        verify(specialityRepository, atLeastOnce()).deleteById(1L);
    }

    @Test
    void deleteByIdAtMost() {
        service.deleteById(1L);
        service.deleteById(1L);
        verify(specialityRepository, atMost(5)).deleteById(1L);
    }

    @Test
    void deleteByIdNever() {
        service.deleteById(1L);
        service.deleteById(1L);
        verify(specialityRepository, atLeastOnce()).deleteById(1L);
        verify(specialityRepository, never()).deleteById(5L);
    }

    @Test
    void deleteById() {
        service.deleteById(1l);
    }
}


















