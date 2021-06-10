package com.example.demo.controller;

import com.example.demo.service.CommuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommuneController {

    @Autowired
    CommuneService communeService;

    @RequestMapping(value = "/commune", method = RequestMethod.GET)
    public String commune(Model model) {
        model.addAttribute("communes", communeService.findAll());
        return "commune";
    }
}