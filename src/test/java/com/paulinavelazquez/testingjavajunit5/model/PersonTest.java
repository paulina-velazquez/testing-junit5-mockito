package com.paulinavelazquez.testingjavajunit5.model;

import com.paulinavelazquez.testingjavajunit5.ModelTests;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest implements ModelTests {

    @Test
    void groupedAssertions() {
        // given
        Person person = new Person(1L, "Veronica", "Sambors");

        // then
        assertAll("Test Props Set",
                () -> assertEquals("Veronica", person.getFirstName(), "First name do not match"),
                () -> assertEquals("Sambors", person.getLastName(), "Last name do not match"));
    }

    @Test
    void groupedAssertionsFail() {
        // given
        Person person = new Person(1L, "Veronica", "Sambors");

        // then
        assertAll("Test Props Set",
                () -> assertEquals("Veronica", person.getFirstName(), "First name do not match"),
                () -> assertEquals("Sambors", person.getLastName(), "Last name do not match"));
    }
}




















