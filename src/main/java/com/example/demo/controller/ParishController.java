package com.example.demo.controller;

import com.example.demo.model.Parish;
import com.example.demo.service.CommuneService;
import com.example.demo.service.ParishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ParishController {

    @Autowired
    ParishService parishService;
    @Autowired
    CommuneService communeService;

    @RequestMapping(value = "/parish", method = RequestMethod.GET)
    public String parish(Model model) {
        model.addAttribute("parishes", parishService.findAll());
        return "parish";
    }

    @RequestMapping(value = "/createParish", method = RequestMethod.GET)
    public String createParish() {
        return "createParish";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute Parish parish) {
        Parish newParish = parishService.create(parish);
        parishService.update(newParish);
        return "redirect:/";
    }

    @GetMapping("/update/{parishCode}")
    public String update(@PathVariable("parishCode") long parishCode, Model model) {
        model.addAttribute("parish", parishService.findById(parishCode));
        model.addAttribute("communes", communeService.findAll());
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Parish parish) {
        parishService.update(parish);
        return "redirect:/parish";
    }

    @GetMapping("/delete/{parishCode}")
    public String delete(@PathVariable("parishCode") long parishCode, Model model) {
        parishService.deleteById(parishCode);
        return "redirect:/parish";
    }
}