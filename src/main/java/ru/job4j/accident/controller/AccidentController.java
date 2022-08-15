package ru.job4j.accident.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.service.AccidentService;

@Controller
public class AccidentController {

    private final AccidentService accidentService;

    public AccidentController(AccidentService accidentService) {
        this.accidentService = accidentService;
    }

    @GetMapping("/accident")
    public String accident(Model model) {
        model.addAttribute("accidents", accidentService.findAll());
        return "accident";
    }

    @GetMapping("/formCreateAccident")
    public String formAccident() {
        return "create";
    }

    @PostMapping("/createAccident")
    public String createAccident(@ModelAttribute Accident accident) {
        accidentService.create(accident);
        return "redirect:/accident";
    }

    @GetMapping("/formUpdateAccident/{accidentId}")
    public String formUpdateAccident(Model model, @PathVariable("accidentId") int id) {
        model.addAttribute("accident", accidentService.findById(id));
        return "update";
    }

    @PostMapping("/updateAccident")
    public String updateAccident(@ModelAttribute Accident accident) {
        accidentService.update(accident);
        return "redirect:/accident";
    }
}
