package com.example.demo.controller;

import com.example.demo.DataFeeder;
import com.example.demo.service.CommuneService;
import com.example.demo.service.ParishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StartUpController {

    @Autowired
    CommuneService communeService;
    @Autowired
    ParishService parishService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "redirect:/feedCommuneData";
    }

    @RequestMapping(path = "feedCommuneData")
    public String feedCommuneData() {
        communeService.feedCommuneData();
        return "redirect:/feedParishData";
    }

    @RequestMapping(path = "feedParishData")
    public String feedParishData(){
        parishService.feedParishData();
        return "redirect:/parish";
    }
}