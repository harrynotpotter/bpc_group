package com.example.bpc_group.controllers;

import com.example.bpc_group.models.entity.Lord;
import com.example.bpc_group.models.entity.Planet;
import com.example.bpc_group.services.LordService;
import com.example.bpc_group.services.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    @Autowired
    private LordService lordService;
    @Autowired
    private PlanetService planetService;


    @GetMapping("/lords")
    public String getLords(Model model) {
        model.addAttribute("lords", lordService.getAllLords());
        model.addAttribute("lord");
        return "lords";
    }

    @PostMapping("/lords/add")
    public String addLord(@ModelAttribute(value = "lord") Lord lord) {
        lordService.addLord(lord);
        return "redirect:/lords";
    }

    @GetMapping("/lords/top")
    public String findTop10Lords(Model model){
        model.addAttribute("lords",lordService.findTop10Lords());
        return "top";
    }

    @GetMapping("/planets")
    public String getPlanets(Model model) {
        model.addAttribute("lords",lordService.getAllLords());
        model.addAttribute("planets", planetService.getAllPlanets());
        model.addAttribute("planet");
        return "planets";
    }

    @GetMapping("/lords/lazy")
    public String findLazyLords(Model model) {
        model.addAttribute("lazyLords", lordService.findLazyLords());
        return "lazy";
    }



    @PostMapping("/planets/add")
    public String addPlanet(@ModelAttribute(value = "planet") Planet planet) {
        planetService.addPlanet(planet);
        return "redirect:/planets";
    }

    @GetMapping("/planets/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        planetService.destroyPlanet(id);
        return "redirect:/planets";
    }
}
