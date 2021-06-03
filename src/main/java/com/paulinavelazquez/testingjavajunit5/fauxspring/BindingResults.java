package com.paulinavelazquez.testingjavajunit5.fauxspring;

public interface BindingResults {
    void rejectValue(String lastName, String notFound, String not_found);
    boolean hasErrors();
}
