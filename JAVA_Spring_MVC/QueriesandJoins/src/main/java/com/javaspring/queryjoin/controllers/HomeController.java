package com.javaspring.queryjoin.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.javaspring.queryjoin.services.CountryService;

@Controller
public class HomeController {
  @Autowired
  private CountryService countryService;

  @GetMapping("/")
  public String showAll(Model model){
    List<Object[]> task1 =countryService.findCountriesSpeakingSlovene();
    List<Object[]> task2 =countryService.findNumberOfCitiesPerCountry();
    List<Object[]> task3 =countryService.findPopulationInMexico();
    List<Object[]> task4 =countryService.findLanguages();
    List<Object[]> task5 =countryService.findCountriesBySurfaceArea();
    List<Object[]> task6 =countryService.findCountriesByGovermentForm();
    List<Object[]> task7 =countryService.findCitiesInArgantina();
    List<Object[]> task8 =countryService.numberRegion();

    
    model.addAttribute("task1", task1);
    model.addAttribute("task2", task2);
    model.addAttribute("task3", task3);
    model.addAttribute("task4", task4);
    model.addAttribute("task5", task5);
    model.addAttribute("task6", task6);
    model.addAttribute("task7", task7);
    model.addAttribute("task8", task8);

    return "index.jsp";
  }

}