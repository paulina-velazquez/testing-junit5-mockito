package com.paulinavelazquez.testingjavajunit5.controllers;

import com.paulinavelazquez.testingjavajunit5.ControllerTests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class IndexControllerTest implements ControllerTests {

    IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    @DisplayName("Test Proper View name is returned for index page")
    @Test
    void index() {
        assertEquals("index", controller.index(), "wrong view returned");
    }

    @DisplayName("Test Property View using AssertJ")
    @Test
    void testingIndexUsingAssertJ() {
        assertThat(controller.index()).isEqualTo("index");
    }

    @DisplayName("Test Exception")
    @Test
    void exceptionHandler() {
        assertThrows(ValueNotFoundException.class, () -> {
            controller.exceptionHandler();
        });
    }

    @DisplayName("Demo of Timeout")
    @Test
    void testTimeOut() {
        assertTimeout(Duration.ofMillis(1000), () -> {
            Thread.sleep(500);
            System.out.println("Inside testTimeout test");
        });
    }

    @DisplayName("Demo of Timeout Preemptively")
    @Test
    void testTimeOutPrempt() {
        assertTimeoutPreemptively(Duration.ofMillis(1000), () -> {
            Thread.sleep(200);
            System.out.println("Inside testTimeOutPremt test");
        });
    }

    @Test
    void testAssumptionTrue() {
        assumeTrue("GURU".equalsIgnoreCase(System.getenv("GURU_RUNTIME")));
    }

    @Test
    void testAssumptionTrueAssumptionIsTrue() {
        assumeTrue("GURU".equalsIgnoreCase(System.getenv("GURU")));
    }

    // Conditional Execution

    @EnabledOnOs(OS.MAC)
    @Test
    void testMeOnMacOS() {
    }

    @EnabledOnOs(OS.WINDOWS)
    @Test
    void testMeOnWindows() {
    }

    @EnabledOnJre(JRE.JAVA_8)
    @Test
    void testMeOnJava8() {
    }

    @EnabledOnJre(JRE.JAVA_11)
    @Test
    void testMeOnJava11() {
    }

    @EnabledIfEnvironmentVariable(named = "USER", matches = "PAU")
    @Test
    void testIfUserPau() {
    }

    @EnabledIfEnvironmentVariable(named = "USER", matches = "FRED")
    @Test
    void testIfUserFred() {
    }
}