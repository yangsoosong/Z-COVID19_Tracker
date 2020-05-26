package com.example.coronavirustracker.controllers;


import com.example.coronavirustracker.models.LocationStats;
import com.example.coronavirustracker.services.CoronaVirusDataService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    CoronaVirusDataService coronaVirusDataService;

    @GetMapping("/")
    public String home(Model model) {
        List<LocationStats> allStats =coronaVirusDataService.getAllStats();
        int TotalReportedCases = allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
        model.addAttribute("LocationStats", allStats);
        model.addAttribute("TotalReportedCases", TotalReportedCases);

        return "home";
    }

}
