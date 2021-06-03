package com.paulinavelazquez.testingjavajunit5.controllers;

import com.paulinavelazquez.testingjavajunit5.fauxspring.Model;
import com.paulinavelazquez.testingjavajunit5.services.VetService;

public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    public String listVets(Model model) {
        model.addAttribute("vets", vetService.findAll());
        return "vets/index";
    }
}
