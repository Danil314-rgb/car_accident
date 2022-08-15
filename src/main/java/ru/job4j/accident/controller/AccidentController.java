package ru.job4j.accident.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.service.AccidentService;
import ru.job4j.accident.service.AccidentTypeService;

@Controller
public class AccidentController {

    private final AccidentService accidentService;
    private final AccidentTypeService accidentTypeService;

    public AccidentController(AccidentService accidentService, AccidentTypeService accidentTypeService) {
        this.accidentService = accidentService;
        this.accidentTypeService = accidentTypeService;
    }

    @GetMapping("/accident")
    public String accident(Model model) {
        model.addAttribute("accidents", accidentService.findAll());
        return "accident";
    }

    @GetMapping("/formCreateAccident")
    public String formAccident(Model model) {
        model.addAttribute("types", accidentTypeService.findAll());
        return "create";
    }

    @PostMapping("/createAccident")
    public String createAccident(@ModelAttribute Accident accident) {
        AccidentType type = accidentTypeService.findById(accident.getType().getId());
        accident.setType(type);
        accidentService.create(accident);
        return "redirect:/accident";
    }

    @GetMapping("/formUpdateAccident/{accidentId}")
    public String formUpdateAccident(Model model, @PathVariable("accidentId") int id) {
        model.addAttribute("types", accidentTypeService.findAll());
        model.addAttribute("accident", accidentService.findById(id));
        return "update";
    }

    @PostMapping("/updateAccident")
    public String updateAccident(@ModelAttribute Accident accident) {
        AccidentType type = accidentTypeService.findById(accident.getType().getId());
        accident.setType(type);
        accidentService.update(accident);
        return "redirect:/accident";
    }
}
