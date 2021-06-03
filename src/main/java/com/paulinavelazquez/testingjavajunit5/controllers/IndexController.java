package com.paulinavelazquez.testingjavajunit5.controllers;

public class IndexController {

    public String index() {
        return "index";
    }

    public String oopsHandlerNotImplemented() {
        return "notimplemented";
    }

    public void exceptionHandler() {
        throw new ValueNotFoundException();
    }
}
