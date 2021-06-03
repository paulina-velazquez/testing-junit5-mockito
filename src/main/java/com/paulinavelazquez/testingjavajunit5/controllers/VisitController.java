package com.paulinavelazquez.testingjavajunit5.controllers;

import com.paulinavelazquez.testingjavajunit5.model.Pet;
import com.paulinavelazquez.testingjavajunit5.model.Visit;
import com.paulinavelazquez.testingjavajunit5.services.PetService;
import com.paulinavelazquez.testingjavajunit5.services.VisitService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;

import javax.validation.Valid;
import java.util.Map;

public class VisitController {

    private final VisitService visitService;
    private final PetService petService;

    public VisitController(VisitService visitService, PetService petService) {
        this.visitService = visitService;
        this.petService = petService;
    }

    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    public Visit loadPetWithVisit(Long petId, Map<String, Object> model) {
        Pet pet = petService.findById(petId);
        model.put("pet", pet);
        Visit visit = new Visit();
        pet.getVisits().add(visit);
        visit.setPet(pet);
        return visit;
    }

    public String initNewVisitForm(Long petId, Map<String, Object> model) {
        return "pet/createOrUpdateVisitForm";
    }

    public String processNewVisitForm(@Valid Visit visit, BindingResult result) {
        if (result.hasErrors()) {
            return "pets/createOrUpdateForm";
        } else {
            visitService.save(visit);
            return "redirect:/owners/{ownerId}";
        }
    }
}
