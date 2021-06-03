package com.paulinavelazquez.testingjavajunit5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInfo;

@Tag("model")
public interface ModelTests {

    @BeforeEach
    default void beforeEachConsoleOutputter(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName());
    }
}
